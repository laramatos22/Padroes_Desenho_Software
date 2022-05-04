package ex2;

public class CakeMaster{ //decide a ordem de colocar peças cujo conteudo o builder é que decide
    private CakeBuilder cbuilder;

    public CakeMaster(){}

    public void setCakeBuilder(CakeBuilder cbuilder){
        this.cbuilder=cbuilder;
    }

    public void createCake(String m){
        this.createCake(Shape.Circle, 1, m);

    }
    public void createCake(int nlayers){
        this.createCake(Shape.Circle, nlayers, "default");

    }
    public void createCake(Shape shape){
        this.createCake(shape, 1, "default");

    }
    public void createCake(Shape shape, String m){
        this.createCake(shape, 1, m);

    }
    public void createCake(int nlayers, String m){
        this.createCake(Shape.Circle, nlayers,m);

    }
    public void createCake(Shape shape,int nlayers){
        this.createCake(shape, nlayers, "default");
    }
    public void createCake(Shape shape, int nlayers, String m){
        //initialize cake
        cbuilder.CreateCake();
        cbuilder.addMessage(m);       //add message to cake
        for(int i=1; i<nlayers; i++){ //add n number of layers to cake
            cbuilder.addCakeLayer();
        }
        cbuilder.setCakeShape(shape); //set shape of cake
        //---Building the cake-----
        if(nlayers!=1)cbuilder.addCreamLayer();
        cbuilder.addTopLayer();
        cbuilder.addTopping();
    }
    public Cake getCake(){
        return cbuilder.getCake();
    }

    /*
        public void addCakeLayer();
    public void addCreamLayer();
    public void addTopLayer();
    public void addTopping();
    public void addMessage(String m);
    */
}
