package JsonObjects;

import JsonObjects.Objects.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class JsonInteraction {

    public User[] deserializeJSON(String path) {
        Gson gson = new GsonBuilder().create();
        User[] usuaris = null;
        try{
            usuaris = gson.fromJson(new BufferedReader(new FileReader(path)),User[].class);
        }catch (FileNotFoundException e){
            System.out.println("No s'ha llegit correctament el JSON");
        }
        return usuaris;
    }

    public void serializeJSON(ArrayList<Object> obj, String name) {
        try (Writer writer = new FileWriter("jsons/" + name + ".json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(obj, writer);
        } catch (IOException e) {
            System.out.println("Problema en crear el JSON del resultat de l'ordenacio.");;
        }
    }

}
