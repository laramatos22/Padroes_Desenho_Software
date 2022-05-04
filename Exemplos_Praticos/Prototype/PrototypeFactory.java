package Prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static enum ModelType {
        MOVIE, ALBUM, SHOW;
    }

    private static Map<ModelType, PrototypeCapable> prototypes = new HashMap<>();
    
    static {
        prototypes.put(ModelType.MOVIE, new Movie());
        prototypes.put(ModelType.ALBUM, new Album());
        prototypes.put(ModelType.SHOW, new Show());
    }

    public static PrototypeCapable getInstance(ModelType s)
                                    throws CloneNotSupportedException {
        return (prototypes.get(s)).clone();
    }
}
