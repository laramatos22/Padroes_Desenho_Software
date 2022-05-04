package Builder;

/**
 * O primeiro ConcreteBuilder é o ItalianMealBuilder. Ele cria a refeição
 * e os seus métodos são implementados para construir as várias partes da
 * refeição. A refeição é retornada através do getMeal().
 */

public class ItalianMealBuilder implements MealBuilder {
    private Meal meal;

    public ItalianMealBuilder() {meal = new Meal();}

    @Override
    public void buildBebida() {meal.setBebida("vinho tinto");}

    @Override
    public void buildPrato() {meal.setPrato("pizza");}

    @Override
    public void buildEntrada() {meal.setEntrada("pão");}

    @Override
    public Meal getMeal() {return meal;}
}
