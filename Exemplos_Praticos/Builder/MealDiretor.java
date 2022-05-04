package Builder;

/**
 * A classe diretora é o MealDiretor. 
 * É preciso um MealBuilder como parâmetro no seu construtor.
 * Assim, uma interface refeição diferente será construída pelo MealDiretor
 * dependendo do ConcretBuilder passado no construtor.
 * A montagem da refeição (Produto) ocorre no método constructMeal() do MealDiretor. 
 * Este método indica os ingredientes que constituirá a refeição.
 */

public class MealDiretor {

    private MealBuilder mealbuidler = null;

    public MealDiretor (MealBuilder mealbuilder) {this.mealbuidler = mealbuilder;}

    // função agregadora
    public void constructMeal() {
        mealbuidler.buildBebida();
        mealbuidler.buildEntrada();
        mealbuidler.buildPrato();
    }

    // retorno da comida
    public Meal getMeal() {
        return mealbuidler.getMeal();
    }
    
}
