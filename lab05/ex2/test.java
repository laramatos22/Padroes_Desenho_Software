package ex2;

public class test {
    public static void main(String[] args){
        CakeMaster cakeMaster= new CakeMaster();
        CakeBuilder chocolate= new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations"); // 1 cake layer
        Cake cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);
        
        CakeBuilder sponge= new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");// squared, 2 layers
        cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);
        
        CakeBuilder yogurt= new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");// 3 cake layers
        cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);//you should add here other example(s)of CakeBuilder


        System.out.println();
        System.out.println("Extra cakes");
        CakeBuilder berries= new BerriesCakeBuilder();
        cakeMaster.setCakeBuilder(berries);
        cakeMaster.createCake(Shape.Rectangle,6, "Born to be wild");// 3 cake layers
        cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);//you should add here other example(s)of CakeBuilder

        CakeBuilder eight= new AfterEightCakeBuilder();
        cakeMaster.setCakeBuilder(eight);
        cakeMaster.createCake(10, "Minty and tall");// 3 cake layers
        cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);//you should add here other example(s)of CakeBuilder
    }
}
