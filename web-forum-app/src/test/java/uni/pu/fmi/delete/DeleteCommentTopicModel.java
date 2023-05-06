package uni.pu.fmi.delete;

import org.apache.commons.lang3.StringUtils;

import uni.pu.fmi.controllers.GeneralController;

public class DeleteCommentTopicModel  {

	//item is comment or topic
	private int itemId;
	
	private int currentUserId;
	private Boolean isAdmin;
	private Boolean isComment;
	private String message;
	private GeneralController commentTopicController;
	
	public DeleteCommentTopicModel(Boolean isComment) {
		commentTopicController = new GeneralController();
		this.isComment = isComment;
	}
	
	public void hasItemId(final String itemId) {
		if(itemId.isBlank() || !StringUtils.isNumeric(itemId) ) this.itemId = -1;
		else this.itemId = Integer.parseInt(itemId);
	}
	
	public void hasCurrentUserId(final String currentUserId) {
		if(currentUserId.isBlank() || !StringUtils.isNumeric(currentUserId) ) this.currentUserId = -1;
		else this.currentUserId = Integer.parseInt(currentUserId);
	}
	
	public void authorizeAndDelete() {
		String checkCorrection;
		if(isComment) {
			checkCorrection = commentTopicController.checkCorrectionComment(itemId, currentUserId);
		}
		else {
			checkCorrection = commentTopicController.checkCorrectionTopic(itemId, currentUserId);
		}
		
		//check if id's are correct
		if("Correct" == checkCorrection) {
			//check if the user is administrator
			this.isAdmin = commentTopicController.isAdmin();
			
			//start deletion
			if(isComment) {
				this.message = commentTopicController.deleteComment(isAdmin);	
			}
			else {
				this.message = commentTopicController.deleteTopic(isAdmin);
			}
		}
		//if aren't correct set the error message; 
		else this.message = checkCorrection;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
