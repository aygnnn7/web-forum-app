package uni.pu.fmi.create;

import uni.pu.fmi.controllers.GeneralController;

public class CreateCommentModel {

	private String text;
	private int rating;
	private String message;
	
	public void addText(final String text) {
		this.text= text;
	}
	public void addRating(final String rating) {
		if(rating.isBlank()) this.rating = 0;
		else this.rating = Integer.parseInt(rating);
	    
	}
	public void clickCommentButton() {
		GeneralController commentController = new GeneralController();
		this.message = commentController.createComment(text, rating);
	}
	public String getMessage() {
		return this.message;
	}
	
}
