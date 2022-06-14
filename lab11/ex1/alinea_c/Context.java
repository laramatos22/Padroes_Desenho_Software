package ex1.alinea_c;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Telemovel[] sort(Telemovel[] lista_telemoveis) {
        return strategy.sort(lista_telemoveis);
    }
    
}
