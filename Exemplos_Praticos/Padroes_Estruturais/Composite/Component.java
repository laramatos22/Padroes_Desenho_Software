package Padroes_Estruturais.Composite;

/**
 * Declaração da interface Componente que declara quais as operações que são 
 * comuns para a classe Composite e classe Folha.
 * Isto permite realizar operações em "compósitos" e folhas, utilizando
 * uma interface padrão.
 */

public interface Component {
    public void sayHello();
    public void sayGoodBye();
}
