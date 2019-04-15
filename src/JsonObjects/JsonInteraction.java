package JsonObjects;

import java.util.ArrayList;

public interface JsonInteraction {
    abstract Object[] deserializeJSON(String path);
    abstract void serializeJSON(ArrayList<Object> obj, String name);
}
