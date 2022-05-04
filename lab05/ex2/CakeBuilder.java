package ex2;

public interface CakeBuilder {
    public void setCakeShape(Shape shape); //default circle
    public void addCakeLayer();
    public void addCreamLayer();
    public void addTopLayer();
    public void addTopping();
    public void addMessage(String m);
    public void CreateCake();
    public Cake getCake();
}

class ChocolateCakeBuilder implements CakeBuilder{
    private Cake cake;

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
    public void addCakeLayer(){
        cake.addLayer();
    }
    public void addCreamLayer(){
        cake.addCreamLayer(Cream.Chocolate);
    }
    public void addTopLayer(){
        cake.addTopLayer(Cream.Whipped_Cream);
    }
    public void addTopping(){
        cake.addTopping(Topping.Fruit);
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public void CreateCake(){
        cake = new Cake(1,"default");
        cake.setCakeLayer("Soft chocolate");
    }
    public Cake getCake(){
        return this.cake;
    }

    @Override
    public String toString(){
        return cake.toString();
    }
}

//----------------------------------

class YogurtCakeBuilder implements CakeBuilder{
    private Cake cake;

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
    public void addCakeLayer(){
        cake.addLayer();
    }
    public void addCreamLayer(){
        cake.addCreamLayer(Cream.Vanilla);
    }
    public void addTopLayer(){
        cake.addTopLayer(Cream.Red_berries);
    }
    public void addTopping(){
        cake.addTopping(Topping.Chocolate);
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public void CreateCake(){
        cake = new Cake(1,"default");
        cake.setCakeLayer("Yogurt");
    }
    public Cake getCake(){
        return this.cake;
    }

    @Override
    public String toString(){
        return cake.toString();
    }
}

//-----------------------------
class SpongeCakeBuilder implements CakeBuilder{
    private Cake cake;

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
    public void addCakeLayer(){
        cake.addLayer();
    }
    public void addCreamLayer(){
        cake.addCreamLayer(Cream.Red_berries);
    }
    public void addTopLayer(){
        cake.addTopLayer(Cream.Whipped_Cream);
    }
    public void addTopping(){
        cake.addTopping(Topping.Fruit);
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public void CreateCake(){
        cake = new Cake(1,"default");
        cake.setCakeLayer("Sponge");
    }
    public Cake getCake(){
        return this.cake;
    }

    @Override
    public String toString(){
        return cake.toString();
    }
}

//-----------------------------
class BerriesCakeBuilder implements CakeBuilder{
    private Cake cake;

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
    public void addCakeLayer(){
        cake.addLayer();
    }
    public void addCreamLayer(){
        cake.addCreamLayer(Cream.Red_berries);
    }
    public void addTopLayer(){
        cake.addTopLayer(Cream.Blue_Berries);
    }
    public void addTopping(){
        cake.addTopping(Topping.Hazelnuts);
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public void CreateCake(){
        cake = new Cake(1,"default");
        cake.setCakeLayer("Wild berries");
    }
    public Cake getCake(){
        return this.cake;
    }

    @Override
    public String toString(){
        return cake.toString();
    }
}

//-----------------------------
class AfterEightCakeBuilder implements CakeBuilder{
    private Cake cake;

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
    public void addCakeLayer(){
        cake.addLayer();
    }
    public void addCreamLayer(){
        cake.addCreamLayer(Cream.Mint);
    }
    public void addTopLayer(){
        cake.addTopLayer(Cream.Dark_Chocolate);
    }
    public void addTopping(){
        cake.addTopping(Topping.Chocolate);
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public void CreateCake(){
        cake = new Cake(1,"default");
        cake.setCakeLayer("After Eight");
    }
    public Cake getCake(){
        return this.cake;
    }

    @Override
    public String toString(){
        return cake.toString();
    }
}