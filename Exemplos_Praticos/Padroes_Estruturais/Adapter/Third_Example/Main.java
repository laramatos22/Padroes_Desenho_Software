package Padroes_Estruturais.Adapter.Third_Example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Duck: ");
        Duck duck = new MallardDuck();
        test(duck);
    }

    static void test(Duck duck) {
        duck.quack();
        duck.walk();
    }
    
}
