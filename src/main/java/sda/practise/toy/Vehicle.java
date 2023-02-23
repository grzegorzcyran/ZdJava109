package sda.practise.toy;

public class Vehicle extends Toy {

    private ToyType toyType;
    Vehicle(String name, String minAge, int price) {
        super(name, minAge, price);
        toyType = ToyType.VEHICLE;
    }

    public ToyType getToyType() {
        return toyType;
    }
}
