package Padroes_Estruturais.Adapter.Third_Example;

public class TurkeyAdapter implements Duck {
    
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void walk() {
        turkey.walk();
    }
}
