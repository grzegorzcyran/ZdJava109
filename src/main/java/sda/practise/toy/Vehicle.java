package sda.practise.toy;

public class Vehicle extends Toy {

    private ToyType toyType;
    Vehicle(String name, int minAge, int price) {
        super(name, minAge, price);
        toyType = ToyType.VEHICLE;
    }

    public ToyType getToyType() {
        return toyType;
    }

    @Override
    public String info() {
        return new StringBuilder(toyType.getPolishTranslation())
                .append(": ")
                .append(super.info())
                .toString();
    }
}
