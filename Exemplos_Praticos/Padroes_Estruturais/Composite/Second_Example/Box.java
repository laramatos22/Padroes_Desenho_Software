package Padroes_Estruturais.Composite.Second_Example;

import java.util.ArrayList;
import java.util.List;

public class Box extends Entity {
    
    private List<Entity> children = new ArrayList<>();
    private int value;

    public Box(int val) {value = val;}

    public void add(Entity c) {
        children.add(c);
    }

    public void traverse() {
        System.out.println(indent.toString() + value);
        indent.append("   ");
        for (int i = 0; i < children.size(); i++) {
            children.get(i).traverse();;
        }
        indent.setLength(indent.length() - 3);
    }

}
