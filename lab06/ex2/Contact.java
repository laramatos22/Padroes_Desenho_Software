package ex2;

public class Contact {

    private String name;
    private int num;

    public Contact(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {return name;}
    public int getNum() {return num;}

    @Override
    public String toString() {
        return ("Contact: " + name + "\t phone number: " + num);
    }
    
}
