package Padroes_Estruturais.Adapter.Third_Example;

public class MallardDuck implements Duck {
    
    @Override
    public void quack() {
        System.out.println("Quack... quack...");
    }

    @Override
    public void walk() {
        System.out.println("Walking duck...");
    }
}
