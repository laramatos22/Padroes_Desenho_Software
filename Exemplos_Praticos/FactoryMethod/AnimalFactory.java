package FactoryMethod;

/**
 * A classe AnimalFactory irá retornar um objeto animal com base nos dados de entrada.
 * -> Animal é uma classe abstrata.
 * -> A fábrica irá retornar uma subclasse instanciada de Animal.
 */

/** Na implementação do método fábrica, existe um método getAnimal().
 * Este método utiliza uma sequência de caracteres como parâmetro.
 * Caso a sequência seja "canino" retorna um objeto do tipo cão, caso
 *  contrário, retorna um objeto gato.
 */

public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("canino".equals(type))
            return new Dog();
        else return new Cat();
    }
    
}
