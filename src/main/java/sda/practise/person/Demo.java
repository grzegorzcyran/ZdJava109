package sda.practise.person;

import sda.practise.person.Gender;
import sda.practise.person.Person;
import sda.practise.person.PersonByAgeComparator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Person person1 = new Person("Jan", "Kowalski", 33, Gender.MALE, 4);
        Person person2 = new Person("Janina", "Nowak", 18, Gender.FEMALE, 0);
        Person person3 = new Person("Andrzej", "Zduń", 45, Gender.MALE, 2);

        List<Person> people = List.of(person1, person2, person3);
        System.out.println("People older then 30");
        people.stream()
                .filter(each -> each.getAge() > 30)
                .forEach(each -> System.out.println(each.personInfo(true)));

        System.out.println("\nPeople with 2 or 3 children");
        people.stream()
                .filter(person -> person.getNoOfChildren() == 3 || person.getNoOfChildren() ==2)
                .forEach(each -> System.out.println(each.personInfo(false)));


        Person person4 = new Person("Jerzy", "Ząbal", 24, "m", 0);
        Person person5 = new Person("Elżbieta", "Grysik", 15, "f", 0);
        Person person6 = new Person("Wiesława", "Stalowa", 65, "f", 5);

        List<Person> morePeople = List.of(person4, person5, person6);
        System.out.println("\nNew people print");
        morePeople.forEach(person -> System.out.println(person.personInfo(false)));

        person3.addChild(new Person("Patryk", "Zduń", 7, "m", 0));
        person3.addChild(new Person("Weronika", "Zduń", 12, "f", 0));

        System.out.println("\nPerson with children:");
        System.out.println(person3.personInfoWithChildren());

        System.out.println("\nList all the people sorted:");
        Stream.of(people, morePeople)
                .flatMap(Collection::stream)
                .sorted()
                .forEach(each -> System.out.println(each.personInfo(false)));

        System.out.println("\nList all the people sorted by age:");
        Stream.of(people, morePeople)
                .flatMap(Collection::stream)
                //.sorted(new PersonByAgeComparator())
                .sorted(new PersonByAgeComparator().reversed())
                .forEach(each -> System.out.println(each.personInfo(false)));

        person1.addChild(new Person("Mikołaj", "Kowalski", 7, "m", 0));
        person1.addChild(new Person("Klaudia", "Kowalska", 5, "f", 0));
        person1.addChild(new Person("Zuzia", "Kowalska", 3, "f", 0));
        person1.addChild(new Person("Norbert", "Kowalski", 11, "m", 0));

        person6.addChild(new Person("Kasia", "Stalowa", 15, "f", 0));
        person6.addChild(new Person("Ola", "Stalowa", 13, "f", 0));
        person6.addChild(new Person("Kamil", "Stalowy", 2, "m", 0));
        person6.addChild(new Person("Kuba", "Stalowy", 3, "m", 0));
        person6.addChild(new Person("Nina", "Stalowa", 10, "f", 0));

        List<Person> allPeople = Stream.of(people, morePeople)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("\nPrint all the children of all the people: ");
        allPeople.stream()
                .filter(each -> each.getNoOfChildren() != 0) //wyfiltruj tych co mają dzieci
                .map(Person::getChildren) //dla każdej osoby w streamie pobierz listę dzieci i dalej posługuj się listą dzieci
                //map zrobiło przekształcenie Person na List<Person> children
                //po map() mamy Stream(List<Person>) czyli strumień list dzieci
                //flatmap zamienia nam to na Stream(Person)
                .flatMap(Collection::stream)
                //no i teraz mamy płaską strukturę Stream(Person) i możemy każdą osobę wrzucić na drukarkę
                .forEach(child -> System.out.println(child.personInfo(false)));

        System.out.println("\n1. collectors.joining tricks");
        String joiningResult1 = allPeople.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println(joiningResult1);

        System.out.println("\n2. collectors.joining tricks");
        String joiningResult2 = allPeople.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(joiningResult2);

        System.out.println("\n3. collectors.joining tricks");
        String joiningResult3 = allPeople.stream()
                .map(Person::getName)
                .collect(Collectors.joining(">, <", "[<", ">]"));
        System.out.println(joiningResult3);

        System.out.println("\n Reduce - suma lat ludzi");
        int sumOfYears = allPeople.stream()
                .map(Person::getAge)
//                .reduce(0, (x, y) -> x + y);
                //0 - od jakiej wartości początkowej zaczynamy
                //wartoscBiezaca - wartość początkowa lub po wykonaniu zdefiniowanej operjacji na kolejnych
                //                 elementach strumienia (w naszym przypadku wiek kolejnej osoby)
                //kolejnyElement - wiek kolejnej osoby przychodzący w strumieniu
        .reduce(0, (wartoscBiezaca, kolejnyElement) -> wartoscBiezaca + kolejnyElement);
        System.out.println("Suma lat ludzi wynosi: " + sumOfYears);

        System.out.println("\n Wygenerowanie haszmapy z listy");
        Map<String, Person> peopleByName = allPeople.stream()
                //peek - przyjmuje to co jest na wejściu i to samo oddaje na wyjściu
                //umożliwia wykonanie akcji która może ale nie musi mieć wpływu na przebieg programu
                .peek(each -> System.out.println("Peek in between : " + each.personInfo(false)))
                //Function.identity() mówi żeby wykorzystac cały obiekt na którym pracujemy,
                //w tym przypadku jest to jeden z obiektów klasy Person
//                .collect(Collectors.toMap(Person::getName, Function.identity()));
                //zamieniamy na mapę czyli musimy zdefiniować klucz i wartość
                //klucz definiujemy że to będzie name (getName)
                //wartością będzie to co wchodzi do collect ze strumienia,
                //w naszym przypadku wchodzi Person
                .collect(Collectors.toMap(Person::getName, x -> x));
        System.out.println("Sprawdzenie mapy");
        peopleByName.keySet().forEach(System.out::println);
        peopleByName.values().forEach(person -> System.out.println(person.personInfo(false)));

        Map<String, List<Person>> childrenBySurname = allPeople.stream()
                .map(Person::getChildren)
                .flatMap(Collection::stream)
                //Collectors.toMap powoduje że mamy błąd bo jest więcej niż 1 osoba z tym samym nazwiskiem
                //.collect(Collectors.toMap(Person::getSurname, Function.identity()));
                //grupujemy elementy po nazwisku, pakujemy wartości z tym samym nazwiskiem do listy
                .collect(Collectors.groupingBy(Person::getSurname, Collectors.toList()));

        System.out.println("Children by surname");
    }
}
