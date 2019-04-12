package JsonObjects.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonObjects.JsonInteraction;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class User implements JsonInteraction {
    private String username;
    private Timestamp creation;
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

    public Timestamp getCreation() {
        return creation;
    }

    public void setCreation(Timestamp creation) {
        this.creation = creation;
    }

    public ArrayList<String> getTo_follow() {
        return to_follow;
    }

    public void setTo_follow(ArrayList<String> to_follow) {
        this.to_follow = to_follow;
    }

    @Override
    public Object[] deserializeJSON(String path) {
        Gson gson = new GsonBuilder().create();
        User[] usuaris = null;
        try{
            usuaris = gson.fromJson(new BufferedReader(new FileReader(path)),User[].class);
        }catch (FileNotFoundException e){
            System.out.println("No s'ha llegit correctament el JSON");
        }
        return usuaris;
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
