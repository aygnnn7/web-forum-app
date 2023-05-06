package uni.pu.fmi.view;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCommentSteps {
	private ViewCommentModel viewCommentModel;

	@Given("Натискаме бутона My Comments от менюто")
	public void OpenCommentOptions() {
		viewCommentModel = new ViewCommentModel();
	}
	@When("Проверява се дали сме направили коментари преди: {string}")
	public void IsAnyComments(String currentUserId) {
		viewCommentModel.anyComments(currentUserId); 
	}
	@When("Прави се заявка към базата данни")
	public void GetComments() {
		viewCommentModel.getComments();
	}
	
	@Then("Виждаме съобщение относно резултата: {string}")
    public void checkResultMessage(String resultMessage) {
    	Assert.assertEquals(resultMessage, viewCommentModel.getMessage());
    }
	
}
