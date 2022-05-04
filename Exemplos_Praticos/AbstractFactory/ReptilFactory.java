package AbstractFactory;

/**
 * ReptilFactory immplementa getAnimal(). 
 * Retorna um Animal, que é uma cobra ou dinossauro.
 */

public class ReptilFactory extends EspeciesFactory {
    @Override
    public Animal getAnimal(String type) {
        if ("cobra".equals(type))
            return new Cobra();
        else return new Dinossauro();
    }
}
