package sda.practise.toy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToyDemo {

    public static void main(String[] args) {
        Toy legoMustang = Toy.returnToyByTypeAbbrv("kl", "Ford Mustang", 16, 699);
        Toy legoFriends = Toy.returnToyByTypeAbbrv("kl", "Marketplace", 7, 349);
        Toy puzzleTajMahal = Toy.returnToyByTypeAbbrv("pz", "Taj Mahal", 14, 150);
        Toy doll1 = Toy.returnToyByTypeAbbrv("l", "Surfing Barbie", 7, 250);

        List<Toy> toys = List.of(legoMustang, legoFriends, puzzleTajMahal, doll1);

        List<Toy> toysAsArekWanted = List.of(Toy.returnToyByTypeAbbrv("kl", "Ford Mustang", 16, 699),
                Toy.returnToyByTypeAbbrv("kl", "Marketplace", 7, 349),
                Toy.returnToyByTypeAbbrv("l", "Surfing Barbie", 7, 250));

        System.out.println("\n==============================");
        System.out.println("wszystkie zabawki które są przeznaczone dla 12 lat i więcej");
        toys.stream()
                .filter(each -> each.getMinAge() >= 12)
                .forEach(each -> System.out.println(each.info()));

        System.out.println("\n==============================");
        System.out.println("wszystkie puzzle i klocki");
        toys.stream()
                .filter(each -> each.getToyType() == ToyType.BRICKS || each.getToyType() == ToyType.PUZZLE)
                .forEach(each -> System.out.println(each.info()));
//
        System.out.println("\n==============================");
        System.out.println("Policzyć sumę wartości wszystkich lalek");
        int dollsSum = toys.stream()
                .filter(each -> each.getToyType() == ToyType.DOLL)
                .map(Toy::getPrice)
                .reduce(0, (existing, incoming) -> existing + incoming);
        System.out.println("Suma wartości lalek: " + dollsSum);
//        Wypisać do pliku listę zabawek - alfabetycznie
//        Wypisać do pliku listę zabawek - sortując po cenie malejąco
//        Wypisać do pliku listę zabawek wybierając najdroższą zabawkę danego typu - czyli np najdroższe klocki, najdroższe puzzle itd - plik wygenerować w osobnym wątku
//
//        Wypisać podsumowanie ile kosztują łącznie zabawki poszczególnych typów - np pluszaki łącznie 300
        System.out.println("\n==============================");
        System.out.println("podsumowanie ile kosztują łącznie zabawki poszczególnych typów");
        Map<ToyType, Integer> toysValueByType = toys.stream()
                .collect(Collectors.groupingBy(Toy::getToyType, Collectors.toList()))
                .entrySet().stream()
                .map(entry -> countForType(entry))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        toysValueByType.entrySet()
                .stream()
                .forEach(each -> System.out.println(each.getKey().getPolishTranslation() + " : " + each.getValue()));


        System.out.println("\n==============================");
        System.out.println("Przekształcenie wszystkich klocków ogólnego typu zabawki na klocki");
        List<Bricks> bricks = toys.stream()
                .filter(toy -> toy instanceof Bricks)
                .map(each -> (Bricks)each)
                .collect(Collectors.toList());
        System.out.println("wypisuję klocki:");
        bricks.forEach(each -> System.out.println(each.info()));


    }

    private static Map<ToyType, Integer> countForType(Map.Entry<ToyType, List<Toy>> entry) {
        ToyType toyType = entry.getKey();
        Map<ToyType, Integer> result = new HashMap<>();

        int sum = entry.getValue()
                .stream()
                .map(Toy::getPrice)
                .reduce(0, (x, y) -> x + y);
        result.put(toyType, sum);
        return result;
    }
}
