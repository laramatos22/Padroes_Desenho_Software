package ex1;

public class PortionFactory {

    public PortionFactory(String type, Temperature temp) {
        if (type.equals("Beverage")) 
            createBeverage(temp);
        else if (type.equals("Meat")) 
            createMeat(temp);
        else
            System.out.println("Type Not Found");
    }

    public static Portion createMeat(Temperature temp) {
        if (temp == Temperature.WARM)
            return new Pork();
        else
            return new Tuna();
    }

    public static Portion createBeverage (Temperature temp) {
        if (temp == Temperature.WARM)
            return new Milk();
        else        // Temperature.COLD
            return new FruitJuice();
    }
    
}
