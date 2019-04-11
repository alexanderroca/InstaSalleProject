package structures.JsonObjects;

import java.util.ArrayList;

public interface JsonInteraction {

    Object[] deserializeJSON(String path);

    void serializeJSON(ArrayList<Object> obj, String name);
}
