package JsonObjects.Objects;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

public class Post{
    private int id;
    private ArrayList<String> liked_by;
    private long published_when;
    private String published_by;
    private Vector location;
    private ArrayList<String> hashtags;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(ArrayList<String> liked_by) {
        this.liked_by = liked_by;
    }

    public long getPublished_when() {
        return published_when;
    }

    public void setPublished_when(long published_when) {
        this.published_when = published_when;
    }

    public String getPublished_by() {
        return published_by;
    }

    public void setPublished_by(String published_by) {
        this.published_by = published_by;
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }
}
