package Prototype;

import Prototype.PrototypeFactory.ModelType;

public class TestPrototypePattern {
    public static void main(String[] args) {

        try {
            PrototypeCapable proto;
            proto = PrototypeCapable.getInstance(ModelType.MOVIE);
            System.out.println(proto);

            proto = PrototypeCapable.getInstance(ModelType.ALBUM);
            System.out.println(proto);

            proto = PrototypeCapable.getInstance(ModelType.SHOW);
            System.out.println(proto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
