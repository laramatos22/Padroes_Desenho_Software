package AbstractFactory;

/**
 * A classe Demo contém o método Main.
 * Cria um objeto AbstractFactory e a partir deste obtemos
 * o EspeciesFactory (um ReptilFactory) e dois objetos Animal (Dinossauro e Cobra).
 * Após isto, obtemos outro EspeciesFactory (MamiferoFactory) e 
 * obtém mais dois objetos Animal (Cão e Gato).
 */

public class Demo {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = new AbstractFactory();

        EspeciesFactory especiesFactory1 = abstractFactory.getEspeciesFactory("reptil");
        Animal a1 = especiesFactory1.getAnimal("dinossauro");
        System.out.println("a1 sound: " + a1.makeSound());
        Animal a2 = especiesFactory1.getAnimal("cobra");
        System.out.println("a2 sound: " + a2.makeSound());
        
        EspeciesFactory especiesFactory2 = abstractFactory.getEspeciesFactory("mamifero");
        Animal a3 = especiesFactory2.getAnimal("cao");
        System.out.println("a3 sound: " + a3.makeSound());
        Animal a4 = especiesFactory2.getAnimal("gato");
        System.out.println("a4 sound: " + a4.makeSound());
    }
    
}
