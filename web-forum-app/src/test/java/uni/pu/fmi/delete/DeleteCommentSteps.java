package uni.pu.fmi.delete;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteCommentSteps {
	private DeleteCommentTopicModel deleteCommentModel;
	
	@Given("Натиснем бутона за опции на коментар")
	public void OpenCommentOptions() {
	    deleteCommentModel = new DeleteCommentTopicModel(true);
	}
	@When("Коментарът притежава id: {string}")
	public void HasCommentId(String commentId) {
	    deleteCommentModel.hasItemId(commentId);
	}
	@When("Текущ потребител id - коментар: {string}")
	public void HasCurrentUserId(String currentUserId) {
	    deleteCommentModel.hasCurrentUserId(currentUserId);
	}
	@When("Проверка дали има разрешение и реализиране на изтриването на коментар")
	public void UserAuthorization() {
		deleteCommentModel.authorizeAndDelete(); 
	}
	@Then("Виждаме съобщение за изтриване на коментар: {string}")
    public void checkDeleteMessage(String expectedMessage) {
    	Assert.assertEquals(expectedMessage, deleteCommentModel.getMessage());
    }
    
	



}