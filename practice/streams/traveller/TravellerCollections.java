package practice.streams.traveller;

import java.util.*;
import java.util.stream.Collectors;

class Traveller {
    public Integer id;
    public String firstName;
    public String secondName;
    public String lastName;
    List<String> mobileNums;

    Traveller(Integer id, String firstName, String secondName, String lastName, List<String> mobileNums) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.mobileNums = mobileNums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMobileNums() {
        return mobileNums;
    }

    public void setMobileNums(List<String> mobileNums) {
        this.mobileNums = mobileNums;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNums=" + mobileNums +
                '}';
    }
}

public class TravellerCollections {
    public static Collection<String> uniquePhoneNumbers(List<Traveller> persons) {
        List<String> uniquePhoneList = persons.stream()
                .flatMap(obj -> obj.getMobileNums().stream())
                .distinct()
                .toList();
        return uniquePhoneList;
    }

    //Unique collection by combination of first-second-lastname
    public static Collection<Traveller> unique(List<Traveller> persons) {
        Collection<Traveller> uniqueTravellerList = persons.stream()
                .collect(Collectors.toMap(
                        obj -> obj.getFirstName() + "|" + obj.getSecondName() + "|" + obj.getLastName(),
                        obj -> obj,
                        (oldTraveller, newTrveller) -> oldTraveller
                )).values();

        return uniqueTravellerList;
    }

    //Unique collection by combination of first-second-lastname
    public static Collection<Traveller> uniqueUsingComparator(List<Traveller> persons) {
        Collection<Traveller> uniqueTravellerList = persons.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() ->
                                new TreeSet<>(Comparator.comparing(obj -> obj.getFirstName() + "|" + obj.getSecondName() + "|" + obj.getLastName()))
                        ),
                        ArrayList::new
                ));

        return uniqueTravellerList;
    }

    public static void main(String[] args) {
        List<Traveller> persons = new ArrayList<>();
        persons.add(new Traveller(1, "Ivan", "Vasya", "Petr", List.of("123")));
        persons.add(new Traveller(2, "Ivan", "Vasya", "Petr", List.of("456", "987")));
        persons.add(new Traveller(3, "Ivan", "Vasya", "Petr", List.of("123", "234")));
        persons.add(new Traveller(4, "Ivan", "Gupta", "Ivan", List.of("345")));
        persons.add(new Traveller(5, "Petr", "Rama", "Igor", List.of("765")));

        Collection<Traveller> uniquePersons = unique(persons);
        System.out.println("uniquePersons : Size: "+uniquePersons.size()+ " : " + uniquePersons);
        Collection<String> uniqueMobiles = uniquePhoneNumbers(persons);
        System.out.println("UniqueMobiles :" + uniqueMobiles);
        Collection<Traveller> uniqueUsingComparator = uniqueUsingComparator(persons);
        System.out.println("uniqueUsingComparator : Size: "+uniqueUsingComparator.size()+ " : " + uniqueUsingComparator);

        //assert uniquePersons != null && uniquePersons.size() == 3;

    }
}
