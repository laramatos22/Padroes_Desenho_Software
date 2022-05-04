package Prototype;

import Prototype.PrototypeFactory.ModelType;

public interface PrototypeCapable extends Cloneable {
    
    public PrototypeCapable clone() throws CloneNotSupportedException;

    public static PrototypeCapable getInstance(ModelType s) {
        return null;
    }
    
}
