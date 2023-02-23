package sda.practise.toy;

public class Bricks extends Toy {
    private ToyType toyType;
    private int noOfElements;

    public Bricks(String name, String minAge, int price, int noOfElements) {
        super(name, minAge, price);
        this.toyType = ToyType.BRICKS;
        this.noOfElements = noOfElements;
    }

    Bricks(String name, String minAge, int price) {
        super(name, minAge, price);
        this.toyType = ToyType.BRICKS;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public int getNoOfElements() {
        return noOfElements;
    }
}
