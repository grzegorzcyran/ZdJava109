package sda.practise.toy;

public class Puzzle extends Toy {
    private ToyType toyType;
    private int noOfElements;

    public Puzzle(String name, String minAge, int price, int noOfElements) {
        super(name, minAge, price);
        this.toyType = ToyType.PUZZLE;
        this.noOfElements = noOfElements;
    }

    Puzzle(String name, String minAge, int price) {
        super(name, minAge, price);
        this.toyType = ToyType.PUZZLE;
        noOfElements = 0;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public void setNoOfElements(int noOfElements) {
        this.noOfElements = noOfElements;
    }
}
