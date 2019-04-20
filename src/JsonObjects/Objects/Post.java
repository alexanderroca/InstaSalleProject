package JsonObjects.Objects;

import JsonObjects.JsonInteraction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import structures.MyArrayList.MyArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Post implements JsonInteraction {
    private int id;
    private ArrayList<String> liked_by;
    private long published_when;
    private String published_by;
    private Vector location;
    private ArrayList<String> hashtags;
    private MyArrayList<String> my_hashtags;

    public MyArrayList<String> getMy_hashtags() {
        return my_hashtags;
    }

    public void setMy_hashtags(ArrayList<String> hashtags) {
        my_hashtags = new MyArrayList<>(hashtags.size());
        for(int i = 0; i < hashtags.size(); i++)
            my_hashtags.add(hashtags.get(i));
    }

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

    @Override
    public Object[] deserializeJSON(String path) {
        Gson gson = new GsonBuilder().create();
        Post[] posts = null;
        try{
            posts = gson.fromJson(new BufferedReader(new FileReader(path)),Post[].class);
        }catch (FileNotFoundException e){
            System.out.println("No s'ha llegit correctament el JSON");
        }
        return posts;
    }

    @Override
    public void serializeJSON(ArrayList<Object> obj, String name) {
        try (Writer writer = new FileWriter("jsons/" + name + ".json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(obj, writer);
        } catch (IOException e) {
            System.out.println("Problema en crear el JSON del resultat de l'ordenacio.");;
        }
    }
}
