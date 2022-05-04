package Builder;

/**
 * A classe Demo permite demonstrar o padrão Builder.
 * Primeiramente, o diretor constrói uma refeição Italiana. Um ItalianMealBuilder é passado para o
 * construtor do MealDiretor. 
 * A refeição é construída através de mealDiretor.constructMeal( ).
 * A refeição é obtida a partir de mealDiretor via mealDiretor.getMeal( ).
 * A refeição italiana é exibida. Após isto, realizamos o mesmo para a refeição portuguesa.
 */

public class Demo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new ItalianMealBuilder();
        MealDiretor mealDiretor = new MealDiretor(mealBuilder);
        mealDiretor.constructMeal();
        Meal meal = mealDiretor.getMeal();
        System.out.println("meal is = " + meal);

        mealBuilder = new PortugueseMealBuilder();
        mealDiretor = new MealDiretor(mealBuilder);
        mealDiretor.constructMeal();
        meal = mealDiretor.getMeal();
        System.out.println("meal is = " + meal);
    }
}
