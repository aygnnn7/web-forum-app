package uni.pu.fmi.models;

import java.util.*;


public class Topic {

  
    public Topic() {
    	subTopics = new HashSet<Topic>();
    	comments = new HashSet<Comment>();
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	public Set<Topic> getSubTopics() {
		return subTopics;
	}
	public void setSubTopics(Set<Topic> subTopic) {
		this.subTopics = subTopic;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public void addSubTopic(Topic subTopic) {
		subTopics.add(subTopic);
	}
	public void addComment(Comment comment) {
		comments.add(comment);
	}


	private int id;
    private String title;
    private String description;
    private User owner;
    private Set<Topic> subTopics;
    private Set<Comment> comments;
    


}