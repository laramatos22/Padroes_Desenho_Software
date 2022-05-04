package Padroes_Estruturais.Composite;

/**
 * Como visto na saída, o padrão Composite permite-nos realizar operações 
 * sobre os compósitos e as folhas que compõem uma estrutura de árvore
 * através de uma interface comum.
 */

public class CompositeDemo {

    public static void main(String[] args){
        Leaf folha1 = new Leaf("Bob");
        Leaf folha2 = new Leaf("Fred");
        Leaf folha3 = new Leaf("Sue");
        Leaf folha4 = new Leaf("Ellen");
        Leaf folha5 = new Leaf("Joe");

        Composite composite1 = new Composite();
        composite1.add(folha1);
        composite1.add(folha2);

        Composite composite2 = new Composite();
        composite2.add(folha3);
        composite2.add(folha4);

        Composite composite3 = new Composite();
        composite3.add(composite1);
        composite3.add(composite2);
        composite3.add(folha5);

        System.out.println("-Calling ‘sayHello’ na folha1");
        folha1.sayHello();

        System.out.println("-Calling ‘sayHello’ no composite1");
        composite1.sayHello();

        System.out.println("-Calling ‘sayHello’ no composite2");
        composite2.sayHello();

        System.out.println("-Calling ‘sayGoodBye’ no composite3");
        composite3.sayGoodBye();
    }
}
