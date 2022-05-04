package Padroes_Estruturais.Adapter.Second_Example;

public class AdapterDemo2 {

    public static void main(String[] args) {
        Shape[] shapes = { new Rectangle(), new OldRectangle() };
        
        // A begin and end point from a graphical editor
        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 60;
        for (int i = 0; i < shapes.length; ++i)
        shapes[i].draw(x1, y1, x2, y2);
        }
    
}
