package FactoryMethod;

/**
 * A calsse Demo demonstra o uso da fábrica.
 * -> Cria uma fábrica AnimalFactory. A fábrica cria dois objetos Animal.
 * -> O primeiro objeto é um gato de o segundo é um cão.
 * -> A saída de cada objeto é o método makeSound().
 * 
 * Uma fábrica pode ser também utilizada com o padrão Singleton.
 * Para isso, substitui-se AnimalFactory animalfactory = new AnimalFactory();
 * POR:
 * AnimalFactory animalfactory = AnimalFactory.getAnimalFactoryInstance();
 * Nota:
 * Neste exemplo, AnimalFactory.getAnimalFactoryInstance() foi implementado para 
 * retornar um objeto estático de AnimalFactory. Isto resulta num fábrica única 
 * que é instanciada e usada invés de criar uma fábrica nova sempre que necessário.
 */

public class Demo {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal a1 = animalFactory.getAnimal("felino");
        System.out.println("a1 sound: " + a1.makeSound());

        Animal a2 = animalFactory.getAnimal("canino");
        System.out.println("a2 sound: " + a2.makeSound());
    }
    
}
