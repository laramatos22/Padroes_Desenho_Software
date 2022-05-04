package ex1;

public interface Portion {
    public Temperature getTemperature();
    public State getState();
    public String toString();
}

class Milk implements Portion {
    private Temperature temp = Temperature.WARM;
    private State state = State.Liquid;

    public Temperature getTemperature() {return this.temp;}
    public State getState() {return this.state;}

    @Override
    public String toString() {
        StringBuilder string_build = new StringBuilder();
        string_build.append("Milk: ")
                    .append("Temperature ").append(this.temp).append(", ")
                    .append("State ").append(this.state);
        return string_build.toString();
    }
}

class FruitJuice implements Portion {
    private Temperature temp = Temperature.COLD;
    private State state = State.Liquid;
    private String fruitName = "Orange";

    public Temperature getTemperature() {return this.temp;}
    public State getState() {return this.state;}

    @Override
    public String toString() {
        StringBuilder string_build = new StringBuilder();
        string_build.append("FruitJuice: ")
                    .append(this.fruitName).append(", ")
                    .append("Temperature ").append(this.temp).append(", ")
                    .append("State ").append(this.state);
        return string_build.toString();
    }
    
}

class Pork implements Portion {
    private Temperature temp = Temperature.WARM;
    private State state = State.Solid;

    public Temperature getTemperature() {return this.temp;}
    public State getState() {return this.state;}

    @Override
    public String toString() {
        StringBuilder string_build = new StringBuilder();
        string_build.append("Pork: ")
                    .append("Temperature ").append(this.temp).append(", ")
                    .append("State ").append(this.state);
        return string_build.toString();
    }

}

class Tuna implements Portion {
    private Temperature temp = Temperature.COLD;
    private State state = State.Solid;

    public Temperature getTemperature() {return this.temp;}
    public State getState() {return this.state;}

    @Override
    public String toString() {
        StringBuilder string_build = new StringBuilder();
        string_build.append("Tuna: ")
                    .append("Temperature ").append(this.temp).append(", ")
                    .append("State ").append(this.state);
        return string_build.toString();
    }

}
