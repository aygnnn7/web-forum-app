package uni.pu.fmi.createComment.models;

import uni.pu.fmi.controllers.CommentController;

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
		CommentController commentController = new CommentController();
		this.message = commentController.createComment(text, rating);
	}
	public String getMessage() {
		return this.message;
	}
	
}
