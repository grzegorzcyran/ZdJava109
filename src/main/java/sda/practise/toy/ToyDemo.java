package sda.practise.toy;

import java.util.List;

public class ToyDemo {

    public static void main(String[] args) {
        Toy legoMustang = Toy.returnToyByType("kl", "Ford Mustang", "16", 699);
        Toy legoFriends = Toy.returnToyByType("kl", "Marketplace", "7", 349);
        Toy puzzleTajMahal = Toy.returnToyByType("pz", "Taj Mahal", "14", 150);
        Toy doll1 = Toy.returnToyByType("l", "Surfing Barbie", "7", 250);

        List<Toy> toys = List.of(legoMustang, legoFriends, puzzleTajMahal, doll1);

//        Wypisać wszystkie które są przeznaczone dla 12 lat i więcej


//        Wypisać wszystkie puzzle i klocki
//
//        Policzyć sumę wartości wszystkich lalek
//
//        Dodać możliwość wprowadzenia nowej zabawki z numerem rodzaju (tego enuma) np new Klocki(1, nazwa, wiek, cena, ...)
//        Wypisać do pliku listę zabawek - alfabetycznie
//        Wypisać do pliku listę zabawek - sortując po cenie malejąco
//        Wypisać do pliku listę zabawek wybierając najdroższą zabawkę danego typu - czyli np najdroższe klocki, najdroższe puzzle itd - plik wygenerować w osobnym wątku
//
//        Wypisać podsumowanie ile kosztują łącznie zabawki poszczególnych typów - np pluszaki łącznie 300


    }
}
