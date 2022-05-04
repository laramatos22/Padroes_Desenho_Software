package Padroes_Estruturais.Decorator;

/**
 * AnimalDecorator é o Decorator. 
 * Implementa Animal, mas como é classe abstrata, 
 * não precisa de implementar describe().
 */

public abstract class AnimalDecorator implements Animal {

    Animal animal;
    public AnimalDecorator (Animal animal) {
        this.animal = animal;
    }
    
}
