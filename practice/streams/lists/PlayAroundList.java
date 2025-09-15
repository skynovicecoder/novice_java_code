package practice.streams.lists;

import java.util.*;
import java.util.stream.Collectors;

class ConsumerInfo{
    String name;
    String location;
    int telephoneNumber;
    double consumerWallet;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public double getConsumerWallet() {
        return consumerWallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setConsumerWallet(double consumerWallet) {
        this.consumerWallet = consumerWallet;
    }

    public ConsumerInfo(String name, String location, int telephoneNumber, double consumerWallet) {
        this.name = name;
        this.location = location;
        this.telephoneNumber = telephoneNumber;
        this.consumerWallet = consumerWallet;
    }

    @Override
    public String toString() {
        return "ConsumerInfo{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", consumerWallet=" + consumerWallet +
                '}';
    }
}

public class PlayAroundList {
    public static void main(String[] args){
        List<ConsumerInfo> consumerList = new ArrayList<>(
                List.of(
                        new ConsumerInfo("Sky", "Hyderabad", 91999999, 10023),
                        new ConsumerInfo("Rocky", "Delhi", 233444455, 2345),
                        new ConsumerInfo("Gokhu", "Hyderabad", 544333333, 9282),
                        new ConsumerInfo("Naruto", "Pune", 666664444, 222),
                        new ConsumerInfo("Vegeta", "Indore", 777743333, 3322),
                        new ConsumerInfo("Zoro", "Jaipur", 192993911, 111),
                        new ConsumerInfo("Luffy", "Pune", 999999999, 2333))
        );

        Optional<ConsumerInfo> richestConsumer = consumerList.stream()
                .max(Comparator.comparingDouble(ConsumerInfo::getConsumerWallet));
        richestConsumer.ifPresent(System.out::println);

        Optional<Double> maxWallet = consumerList.stream()
                .map(ConsumerInfo::getConsumerWallet)
                .max(Double::compare);
        maxWallet.ifPresent(System.out::println);

        Map<String, List<ConsumerInfo>> mapByLoc = consumerList.stream()
                .collect(Collectors.groupingBy(
                        ConsumerInfo::getLocation
                ));
        System.out.println(mapByLoc);

        Map<String, List<String>> mapByLocAndName = consumerList.stream()
                .collect(Collectors.groupingBy(
                        ConsumerInfo::getLocation,
                        Collectors.mapping(
                                ConsumerInfo::getName,
                                Collectors.toList()
                        )
                ));
        System.out.println(mapByLocAndName);
    }
}
