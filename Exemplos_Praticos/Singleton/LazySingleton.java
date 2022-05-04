package Singleton;

public class LazySingleton {
    
    private String name;
    static private LazySingleton instance=null;

    private LazySingleton(String name) {
        this.name = name;
    }

    static public synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton("Ermita");
        }
        return instance;
    }

    @Override
    public String toString() {
        return name;
    }
}
