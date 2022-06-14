package ex3;

public abstract class Alimento {
    protected static StringBuffer string_buffer = new StringBuffer();
    public abstract double getWeight();
    public abstract void print();
}
