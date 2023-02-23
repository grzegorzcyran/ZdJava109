package sda.practise.toy;

public class Doll extends Toy {
    private ToyType toyType;
    private int height;

    public Doll(String name, String minAge, int price, int height) {
        super(name, minAge, price);
        toyType = ToyType.DOLL;
        this.height = height;
    }

    Doll(String name, String minAge, int price) {
        super(name, minAge, price);
        this.toyType = ToyType.DOLL;
    }

    public int getHeight() {
        return height;
    }
}
