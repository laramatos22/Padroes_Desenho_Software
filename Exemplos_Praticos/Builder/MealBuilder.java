package Builder;

/**
 * Interface do Builder - MealBuilder.
 * Dispõe de métodos para construir uma refeição e 
 * um método para retornar a refeição.
 */

public interface MealBuilder {
    public void buildBebida();
    public void buildPrato();
    public void buildEntrada();
    public Meal getMeal();
}
