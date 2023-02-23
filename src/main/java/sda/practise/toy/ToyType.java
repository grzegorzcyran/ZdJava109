package sda.practise.toy;

public enum ToyType {
    BRICKS(1, "kl", "klocki"),
    DOLL(2, "l", "lalka"),
    VEHICLE(3, "p", "pojazd"),
    PUZZLE(4, "pz", "puzzle");

    private int index;
    private String abbreviation;
    private String polishTranslation;

    ToyType(int index, String abbreviation, String polishTranslation) {
        this.index = index;
        this.abbreviation = abbreviation;
        this.polishTranslation = polishTranslation;
    }

    public static ToyType findByAbbrv(String abbreviation) {
        for(ToyType type : ToyType.values()) {
            if(type.abbreviation.equalsIgnoreCase(abbreviation)) {
                return type;
            }
        }
        return null;
    }

    public static ToyType findByIndex(int index) {
        for(ToyType type : ToyType.values()) {
            if(type.index == index) {
                return type;
            }
        }
        return null;
    }
}
