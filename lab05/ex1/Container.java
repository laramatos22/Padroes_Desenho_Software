package ex1;

public abstract class Container {
    protected Portion portion;

    public Container (Portion p) {this.portion = p;}

    public static Container createContainer(Portion p) {
        if (p.getTemperature() == Temperature.COLD) {
            if (p.getState() == State.Liquid)
                return new PlasticBottle(p);
            else
                return new PlasticBag(p);
        }
        else {      // Temperature.WARM
            if (p.getState() == State.Liquid)
                return new TermicBottle(p);
            else    
                return new Tupperware(p);
        }
    }

}

class PlasticBottle extends Container {
    public PlasticBottle(Portion p) {super(p);}

    @Override
    public String toString() {
        return "PlasticBottle with portion = " + super.portion.toString();
    }
}

class TermicBottle extends Container  {
    public TermicBottle(Portion p) {super(p);}

    @Override
    public String toString() {
        return "TermicBottle with portion = " + super.portion.toString();
    }
}

class Tupperware extends Container {
    public Tupperware(Portion p) {super(p);}

    @Override
    public String toString() {
        return "Tupperware with portion = " + super.portion.toString();
    }
}

class PlasticBag extends Container {
    public PlasticBag(Portion p) {super(p);}

    @Override
    public String toString() {
        return "PlasticBag with portion = " + super.portion.toString();
    }
}
