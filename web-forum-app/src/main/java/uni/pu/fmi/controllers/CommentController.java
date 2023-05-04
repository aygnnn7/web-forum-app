package uni.pu.fmi.controllers;

import org.apache.commons.lang3.StringUtils;

public class CommentController {
    public String createComment(String text, int rating) {
    	if (StringUtils.isBlank(text)) {
            return "Секцията за коментар не може да е празна!";
        }
        if (rating <= 0) {
            return "Успешно добахихте коментар!";
        }
        else {
        	return "Успешно добавихте коментар и оценка!";
        }
    }
}