import JsonObjects.JsonInteraction;
import JsonObjects.Objects.User;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        final String PATH_TEST = "jsons/json_test.json";

        JsonInteraction jInteraction = new JsonInteraction();

        User[] users = jInteraction.deserializeJSON(PATH_TEST);

        System.out.println("END");
    }
}
