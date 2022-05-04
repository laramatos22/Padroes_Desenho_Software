package Padroes_Estruturais.Composite;

import java.util.*;

/**
 * A classe Composite implementa ainterface de Component.
 * Implementa os métodos sayHello() e sauGoodBye(), chamando esses 
 * métodos em todos os seus filhos, que são os Components (uma vez que
 * eles podem ser objetos Leaf e objetos Composite, implementando amboos
 * a interface Componente).
 */

public class Composite implements Component {

    List<Component> components = new ArrayList<Component>();

    @Override
    public void sayHello() {
        for (Component component : components) {
            component.sayHello();
        }
    }

    @Override
    public void sayGoodBye() {
        for (Component component : components) {
            component.sayGoodBye();
        }
    }

    public void add (Component comp) {components.add(comp);}
    public void remove (Component comp) {components.remove(comp);}
    public List<Component> getComponents() {return components;}
    public Component getComponent (int i) {return components.get(i);}
    
}
