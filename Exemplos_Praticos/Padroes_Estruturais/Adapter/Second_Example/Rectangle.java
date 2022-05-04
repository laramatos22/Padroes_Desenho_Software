package Padroes_Estruturais.Adapter.Second_Example;

public class Rectangle implements Shape {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("rectangle form (" + x1 + "," + y2 + ") to (" + x2 + "," + y2 + ")");
    }
}
