package sda.practise.toy;

public class Doll extends Toy {
    private ToyType toyType;
    private int height;

    public Doll(String name, int minAge, int price, int height) {
        super(name, minAge, price);
        toyType = ToyType.DOLL;
        this.height = height;
    }

    Doll(String name, int minAge, int price) {
        super(name, minAge, price);
        this.toyType = ToyType.DOLL;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public ToyType getToyType() {
        return toyType;
    }

    @Override
    public String info() {
        return new StringBuilder(toyType.getPolishTranslation())
                .append(": ")
                .append(super.info())
                .append(", height: ")
                .append(height)
                .toString();
    }
}
