package uni.pu.fmi.models;

import java.util.*;


public class User {
	
    public User() {
    }

    private int id;
    private String username;
    private String password;
    private String email;
    private Boolean isAdmin;
    private Set<Topic> topics;
    private Set<Comment> comments;
    
    public Set<Comment> getComments() {
        return this.comments;
    }

    public Set<Topic> getTopics() {
        return this.topics;
    }

    
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        
        return this.email;
    }

    public Boolean authenticateIsAdmin() {
        return this.isAdmin;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pass) {
        this.password=pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}