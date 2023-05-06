package uni.pu.fmi.models;


public class Comment {

   
    public Comment() {
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getTopicId() {
		return this.topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}


	private int id;
    private int rating ;
    private String text;
    private User owner;
    private int topicId;

}