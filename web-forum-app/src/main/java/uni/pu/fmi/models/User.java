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
        // TODO implement here
        return null;
    }

    public Set<Topic> getTopics() {
        // TODO implement here
        return null;
    }

    public String getUsername() {
        // TODO implement here
        return "";
    }

    public String getPassword() {
        // TODO implement here
        return "";
    }

 
    public String getEmail() {
        // TODO implement here
        return "";
    }

    public Boolean authenticateIsAdmin() {
        // TODO implement here
        return false;
    }

    public int getId() {
        // TODO implement here
        return 0;
    }

    public void setUsername(String username) {
        // TODO implement here
    }

    public void setPassword(String pass) {
        // TODO implement here
    }

    public void setEmail(String email) {
        // TODO implement here
    }

    public void setIsAdmin(Boolean isAdmin) {
        // TODO implement here
    }

}