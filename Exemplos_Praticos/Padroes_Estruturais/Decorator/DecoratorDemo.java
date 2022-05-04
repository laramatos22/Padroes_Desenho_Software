package Padroes_Estruturais.Decorator;

/**
 * A classe Decorator Demo demonstra o padrão Decorator.
 * 
 * Primeiro, um objeto LivingAnimal é criado e referenciado através da referência Animal(). 
 * O método describe() é chamado. Após isto, envolvemos o LivingAnimal num objeto
 * e chama-se novamente describe().
 * 
 * Note-se que as pernas foram adicionadas. Após isto, envolvemos o LegDecorator num
 * WingDecorator que acrescenta asas ao nosso animal.
 * 
 * Neste exemplo, usamos a referência Animal para se referir a objetos. Usando esta 
 * abordagem, apenas acedemos às operações partilhadas pela interface Animal, isto é,
 * o método describe().
 * Invés de referenciar a interface, nós podemos referenciar a classe ConcreteDecorator.
 * Isto expõe a funcionalidade excluída do ConcreteDecorator. 
 */

public class DecoratorDemo {

    public static void main(String[] args){

        Animal animal = new LivingAnimal();
        animal.describe();

        animal = new LegDecorator(animal);
        animal.describe();

        animal = new WingDecorator(animal);
        animal.describe();

        animal = new GrowlDecorator(animal);
        animal = new GrowlDecorator(animal);
        animal.describe();
        }
}
