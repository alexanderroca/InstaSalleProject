package JsonObjects.Objects;

import java.sql.Timestamp;
import java.util.ArrayList;

public class User{
    private String username;
    private long creation;
    private ArrayList<String> to_follow;
    private ArrayList<Post> posts;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCreation() {
        return creation;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public ArrayList<String> getTo_follow() {
        return to_follow;
    }

    public void setTo_follow(ArrayList<String> to_follow) {
        this.to_follow = to_follow;
    }
}
