package structures.JsonObjects;

import java.sql.Timestamp;
import java.util.ArrayList;

public class User {
    private String username;
    private Timestamp creation;
    private ArrayList<User> to_follow;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreation() {
        return creation;
    }

    public void setCreation(Timestamp creation) {
        this.creation = creation;
    }

    public ArrayList<User> getTo_follow() {
        return to_follow;
    }

    public void setTo_follow(ArrayList<User> to_follow) {
        this.to_follow = to_follow;
    }
}
