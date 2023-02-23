package sda.practise.toy;

import java.util.List;
import java.util.stream.Collectors;

public class ToyDemo {

    public static void main(String[] args) {
        Toy legoMustang = Toy.returnToyByTypeAbbrv("kl", "Ford Mustang", 16, 699);
        Toy legoFriends = Toy.returnToyByTypeAbbrv("kl", "Marketplace", 7, 349);
        Toy puzzleTajMahal = Toy.returnToyByTypeAbbrv("pz", "Taj Mahal", 14, 150);
        Toy doll1 = Toy.returnToyByTypeAbbrv("l", "Surfing Barbie", 7, 250);

        List<Toy> toys = List.of(legoMustang, legoFriends, puzzleTajMahal, doll1);

//        Wypisać wszystkie które są przeznaczone dla 12 lat i więcej
        toys.stream()
                .filter(each -> each.getMinAge() >= 12)
                .forEach(each -> System.out.println(each.info()));
//        Wypisać wszystkie puzzle i klocki
        System.out.println("\n==============================");
        toys.stream()
                .filter(each -> each.getToyType() == ToyType.BRICKS || each.getToyType() == ToyType.PUZZLE)
                .forEach(each -> System.out.println(each.info()));
//        Policzyć sumę wartości wszystkich lalek
        System.out.println("\n==============================");
//
//        Dodać możliwość wprowadzenia nowej zabawki z numerem rodzaju (tego enuma) np new Klocki(1, nazwa, wiek, cena, ...)
//        Wypisać do pliku listę zabawek - alfabetycznie
//        Wypisać do pliku listę zabawek - sortując po cenie malejąco
//        Wypisać do pliku listę zabawek wybierając najdroższą zabawkę danego typu - czyli np najdroższe klocki, najdroższe puzzle itd - plik wygenerować w osobnym wątku
//
//        Wypisać podsumowanie ile kosztują łącznie zabawki poszczególnych typów - np pluszaki łącznie 300


    }
}
