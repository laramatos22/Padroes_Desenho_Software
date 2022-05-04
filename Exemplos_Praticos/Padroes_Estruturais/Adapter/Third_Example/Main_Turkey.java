package Padroes_Estruturais.Adapter.Third_Example;

public class Main_Turkey {

    public static void main(String[] args) {

        System.out.println("Fake duck (i.e., turkey): ");
        Duck x = new TurkeyAdapter(new Turkey());
        test(x);
    }

    static void test(Duck duck) {
        duck.walk();
        duck.quack();
    }
    
}
