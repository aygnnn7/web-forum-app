package uni.pu.fmi.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import uni.pu.fmi.models.Comment;
import uni.pu.fmi.models.Topic;
import uni.pu.fmi.models.User;

public class GeneralController {
	private Set<User> users = new HashSet<>();
	private Set<Comment> comments = new HashSet<>();
	private Set<Topic> topics = new HashSet<>();
	
	Optional<User> currentUser;
    Optional<Comment> currentComment;
    Optional<Topic> currentTopic;
    
	public GeneralController() {
		//initializing fake database 
		initDb();
	}
	
	private void initDb() {
		//Info: 
		//	user1 is admin
		//	user2 is not admin, owner of the comment1 and comment2
		//	user3 is not admin, owner of the topic1 and topic2
		
		User user = new User();
		user.setId(1);
        user.setEmail("admin@admin.com");
        user.setUsername("test1");
        user.setPassword("test1");
        user.setIsAdmin(true);
        
        User user2 = new User();
        user2.setId(2);
        user2.setEmail("user@user.com");
        user2.setUsername("test2");
        user2.setPassword("test2");
        user2.setIsAdmin(false);
       
        User user3 = new User();
        user3.setId(3);
        user3.setEmail("user2@user2.com");
        user3.setUsername("test3");
        user3.setPassword("test3");
        user3.setIsAdmin(false);
        
        Topic topic = new Topic();
        topic.setId(1);
        topic.setDescription("test topic text");
        topic.setOwner(user3);
        topic.setTitle("test topic title");
        topic.setComments(new HashSet<Comment>());
        
        Topic subTopic = new Topic();
        subTopic.setId(2);
        subTopic.setDescription("sub topic of topic 1");
        subTopic.setOwner(topic.getOwner());
        subTopic.setTitle(topic.getTitle());
        subTopic.setComments(new HashSet<Comment>());
        
        Comment comment = new Comment();
        comment.setOwner(user2);
        comment.setId(1);
        comment.setRating(4);
        comment.setText("I liked it!");
        comment.setTopicId(topic.getId());
        
        Comment comment2 = new Comment();
        comment2.setOwner(user2);
        comment2.setId(2);
        comment2.setRating(2);
        comment2.setText("I did not like it!");
        comment2.setTopicId(topic.getId());
        
        topic.addSubTopic(subTopic);
        topic.addComment(comment);
        topic.addComment(comment2);
        
        users.add(user);
        users.add(user2);
        users.add(user3);
        comments.add(comment);
        comments.add(comment2);
        topics.add(topic);
	}
	
	//Comment
    public String createComment(String text, int rating) {
    	if (StringUtils.isBlank(text)) {
            return "Секцията за коментар не може да е празна!";
        }
    	else if (rating <= 0) {
            return "Успешно добахихте коментар!";
        }
        else {
        	return "Успешно добавихте коментар и оценка!";
        }
    }
    
    public String checkCorrectionComment(int commentId, int currentUserId) {
    	if(currentUserId <= 0 ) {
    		if(commentId<=0) {
    			return "Невалидни id-та на потребител и коментар!";
    		}
    		else return "Невалиден id на потребител!";
    	}
    		
    	else if(commentId <= 0)
    		return "Невалиден id на коментар!";
    	
    	currentUser = users.stream().filter(u -> u.getId() == currentUserId).findFirst();
    	currentComment = comments.stream().filter(c -> c.getId() == commentId).findFirst();
    		
    	if(currentUser.isEmpty()) {
    		if(currentComment.isEmpty()) {
    			return "Потребител и коментар с дадените id-та не съществува!";
    		}
    		else return "Потребител с даденото id не съществува!";
    	}
    	else if(currentComment.isEmpty()) {
    		return "Коментар с даденото id не съществува!";
    	}
    	else {
    		return "Correct";
    	}
    	
    	
    }
    
    public String deleteComment(Boolean isAdmin) {
    	
    	if(isAdmin) {
    		return "Коментарът е изтрит от администратор.";
    	}
    	else if(isOwner(true)) {
    		return "Коментарът е изтрит от собственик.";
    	}
    	else {
    		return "Потребителят няма разрешение да изтрие коментара!";
    	}
    }
    
    public String anyComments(int userId) {
    	Set<Comment> userComments =  comments.stream().filter(u -> u.getId() == userId).collect(Collectors.toSet());
        if(userComments.isEmpty()) {
        	return "Потребителят няма коментар!";
        }
        else
        	return "Yes";
    }
    
    public String getComments() {
    	return "Коментарите се визуализираха успешно.";
    }
    
    //Topic
    public String createTopic(String title, String description) {
    	if (StringUtils.isBlank(title)) {
    		if(StringUtils.isBlank(description)) {
    			return "Секцията за заглавие и описание не може да е празна!";
    		}
            return "Секцията за заглавие не може да е празна!";
        }
    	else if (StringUtils.isBlank(description)) {
    		return "Секцията за описание не може да е празна!";
        }
        else {
        	return "Успешно добавено нов топик.";
        }
    }
    
    public String checkCorrectionTopic(int topicId, int currentUserId) {
    	if(currentUserId <= 0 ) {
    		if(topicId<=0) {
    			return "Невалидни id-та на потребител и топик!";
    		}
    		else return "Невалиден id на потребител!";
    	}
    		
    	else if(topicId <= 0)
    		return "Невалиден id на топик!";
    	
    	currentUser = users.stream().filter(u -> u.getId() == currentUserId).findFirst();
    	currentTopic = topics.stream().filter(c -> c.getId() == topicId).findFirst();
    		
    	if(currentUser.isEmpty()) {
    		if(currentTopic.isEmpty()) {
    			return "Потребител и топик с дадените id-та не съществува!";
    		}
    		else return "Потребител с даденото id не съществува!";
    	}
    	else if(currentTopic.isEmpty()) {
    		return "Топик с даденото id не съществува!";
    	}
    	else {
    		return "Correct";
    	}
    }
    
    public String deleteTopic(Boolean isAdmin) {	
    	if(isAdmin) {
    		return "Топикът е изтрит от администратор.";
    	}
    	else if(isOwner(false)) {
    		return "Топикът е изтрит от собственик.";
    	}
    	else {
    		return "Потребителят няма разрешение да изтрие топика!";
    	}
    }

    //Authorization
    public Boolean isAdmin() {
    	return currentUser.get().authenticateIsAdmin();
    }
    
    public Boolean isOwner(Boolean isComment) {
    	if(isComment) {
    		return currentUser.get().getId() == currentComment.get().getOwner().getId();
    	}
    	else {
    		System.out.println(currentUser.get().getId() == currentTopic.get().getOwner().getId());
    		return currentUser.get().getId() == currentTopic.get().getOwner().getId();
    	}
    }
    
    
}