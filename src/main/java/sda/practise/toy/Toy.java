package sda.practise.toy;

public abstract class Toy {
    private String name;
    private int minAge;
    private int price;

    Toy(String name, int minAge, int price) {
        this.name = name;
        this.minAge = minAge;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getPrice() {
        return price;
    }

    public abstract ToyType getToyType();

    String info() {
        return new StringBuilder(name)
                .append(", minAge: ")
                .append(minAge)
                .append(", price: ")
                .append(price)
                .toString();
    }

    public static Toy returnToyByTypeAbbrv(String typeAbbrv, String name, int minAge, int price) {
        ToyType toyType = ToyType.findByAbbrv(typeAbbrv);

        return returnToyByType(name, minAge, price, toyType);
    }

    private static Toy returnToyByType(String name, int minAge, int price, ToyType toyType) {
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

    public static Toy returnToyByTypeIndex(int typeIndex, String name, int minAge, int price) {
        ToyType toyType = ToyType.findByIndex(typeIndex);
        return returnToyByType(name, minAge, price, toyType);
    }
}
