package uni.pu.fmi.view;

import org.apache.commons.lang3.StringUtils;

import uni.pu.fmi.controllers.GeneralController;

public class ViewCommentModel {
	private GeneralController controller;
	private int currentUserId;
	private String message; 
	
	public ViewCommentModel() {
		controller = new GeneralController();
		this.message = "";
	}
	
	public void anyComments(String currentUserId) {
		if(currentUserId.isBlank() || !StringUtils.isNumeric(currentUserId)) 
			this.currentUserId = -1;
		else 
			this.currentUserId = Integer.parseInt(currentUserId);
		
		String hasComments = controller.anyComments(this.currentUserId);
		if(hasComments != "Yes") this.message = hasComments;
	}
	public void getComments() {
		if(this.message.isBlank()) this.message = controller.getComments();
	}
	public String getMessage()
	{
		return this.message;
	}
 }
