package Singleton;

public class Singleton {

    private String name;

    static private Singleton instance = new Singleton("Ermita");

    private Singleton(String name) {
        this.name = name;
    }

    static public Singleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
