package Padroes_Estruturais.Composite;

/**
 * A classe Leaf tem um campo nome e implementa os métodos sayHello() e 
 * sayGoodBye() da interface Component, indicando as mensagens de saída
 * do padrão.
 */

public class Leaf implements Component {

    String nome;
    public Leaf(String nome) {this.nome = nome;}

    @Override
    public void sayHello() {
        System.out.println("folha " + nome + "diz olá");
    } 

    @Override
    public void sayGoodBye() {
        System.out.println("folha " + nome + "diz adeus");
    }
    
}
