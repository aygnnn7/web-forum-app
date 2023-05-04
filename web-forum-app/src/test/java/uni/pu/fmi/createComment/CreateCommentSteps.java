package uni.pu.fmi.createComment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import uni.pu.fmi.createComment.models.CreateCommentModel;

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
	
	@Then("Виждаме съобщение: {string}")
    public void checkMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, createCommentModel.getMessage());
    }
	



}
