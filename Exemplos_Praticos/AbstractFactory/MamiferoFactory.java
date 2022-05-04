package AbstractFactory;

/**
 * MamiferoFactory implementa getAnimal().
 * Retorna Animal que é cão ou gato.
 */

public class MamiferoFactory extends EspeciesFactory {
    @Override
    public Animal getAnimal(String type) {
        if ("cao".equals(type))
            return new Cao();
        else return new Gato();
    }
}
