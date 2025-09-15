package practice.streams.city;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Person(String name, int age, String city) {
}

public class CityPeople {
    public static Map<String, List<Person>> collectPeople(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(
                        Person::city, //Classifier
                        TreeMap::new, //Supplier
                        Collectors.toList() //Downstream
                ));
    }

    public static Map<String, List<String>> collectPeopleByCity(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        TreeMap::new,
                        Collectors.mapping(
                                //Person::name,
                                Person -> Person.name()+"["+Person.age()+"]",
                                Collectors.toList()
                        )
                ));
    }

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Sonil", 35, "Varanasi"),
                new Person("Sonu", 34, "Raipur"),
                new Person("Rocky", 33, "Hyderabad"),
                new Person("Sky", 32, "Pune"),
                new Person("Chirkut", 30, "Raipur")
        );
        System.out.println(collectPeople(personList));
        System.out.println(collectPeopleByCity(personList));
    }
}
