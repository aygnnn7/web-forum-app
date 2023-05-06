package uni.pu.fmi.delete;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteTopicSteps {
	private DeleteCommentTopicModel deleteTopicModel;
	
	@Given("Натиснем бутона за опции на топик")
	public void OpenTopicOptions() {
		deleteTopicModel = new DeleteCommentTopicModel(false);
	}
	@When("Топик притежава id: {string}")
	public void HasTopicId(String topicId) {
		deleteTopicModel.hasItemId(topicId);
	}
	@When("Текущ потребител id - топик: {string}")
	public void HasCurrentUserId(String currentUserId) {
		deleteTopicModel.hasCurrentUserId(currentUserId);
	}
	@When("Проверка дали има разрешение и реализиране на изтриването на топик")
	public void UserAuthorization() {
		deleteTopicModel.authorizeAndDelete(); 
	}
	@Then("Виждаме съобщение за изтриване на топик: {string}")
    public void checkDeleteMessage(String expectedMessage) {
    	Assert.assertEquals(expectedMessage, deleteTopicModel.getMessage());
    }
}
