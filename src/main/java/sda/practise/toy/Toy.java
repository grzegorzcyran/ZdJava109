package sda.practise.toy;

public abstract class Toy {
    private String name;
    private String minAge;
    private int price;

    Toy(String name, String minAge, int price) {
        this.name = name;
        this.minAge = minAge;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMinAge() {
        return minAge;
    }

    public int getPrice() {
        return price;
    }

    public static Toy returnToyByType(String typeAbbrv, String name, String minAge, int price) {
        ToyType toyType = ToyType.findByAbbrv(typeAbbrv);

        switch (toyType) {
            case DOLL:
                return new Doll(name, minAge, price);
            case BRICKS:
                return new Bricks(name, minAge, price);
            case PUZZLE:
                return new Puzzle(name, minAge, price);
            case VEHICLE:
                return new Vehicle(name, minAge, price);
            default:
                throw new IllegalArgumentException("Toy type undefined");
        }
    }
}
