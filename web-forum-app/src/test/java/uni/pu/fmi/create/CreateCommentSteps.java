package uni.pu.fmi.create;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCommentSteps{
	
	private CreateCommentModel createCommentModel;
	@Given("Натиснем бутона за правене на коментар")
	public void clickMakeComment() {
		createCommentModel = new CreateCommentModel();
	}
	@When("Въведем коментара: {string}")
    public void addText(String text) {
		createCommentModel.addText(text);
    }
	@When("Даваме оценка: {string}")
    public void addRating(String rating) {
		createCommentModel.addRating(rating);
    }
	
	@When("Натиснем бутона за коментиране")
    public void clickLoginButton() {
        createCommentModel.clickCommentButton();
    }
	
	 @Then("Виждаме съобщение за създаване: {string}")
    public void checkCreateMessage(String expectedMessage) {
		Assert.assertEquals(expectedMessage, createCommentModel.getMessage());
    }
}
