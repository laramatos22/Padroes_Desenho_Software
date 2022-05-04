package AbstractFactory;

/**
 * EspeciesFactory é uma classe abstrata com o método
 * getAnimal(). Este método retorna um objeto Animal.
 */

public abstract class EspeciesFactory {
    public abstract Animal getAnimal(String type);
}
