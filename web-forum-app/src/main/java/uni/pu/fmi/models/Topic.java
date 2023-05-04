package uni.pu.fmi.models;

import java.util.*;


public class Topic {

  
    public Topic() {
    }

   
    private int id;
    private String title;
    private String description;
    private User owner;
    private User topicOwner;
    private Topic parentTopic;
    private Set<Topic> subTopic;
    private Set<Comment> comments;
    public void gets() {
        
    }

    public void sets() {
        // TODO implement here
    }

}