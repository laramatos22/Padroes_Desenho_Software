package Builder;

/**
 * O segundo ConcreteBuilder é o PortugueseMealBuilder. Ele cria a refeição
 * e os seus métodos são implementados para construir as várias partes da
 * refeição. A refeição é retornada através do getMeal().
 */

public class PortugueseMealBuilder implements MealBuilder {
    
    private Meal meal;

    public PortugueseMealBuilder() {meal = new Meal();}

    @Override
    public void buildBebida() {meal.setBebida("vinho do porto");}

    @Override
    public void buildPrato() {meal.setPrato("cozido");}

    @Override
    public void buildEntrada() {meal.setEntrada("azeitonas");}

    @Override
    public Meal getMeal() {return meal;}

}
