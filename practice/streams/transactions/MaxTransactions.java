package practice.streams.transactions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Transactions(String id, double amount, String type, String city) {
};

public class MaxTransactions {
    public static Map<String, Double> cityWithMaxTransaction(List<Transactions> inputData) {
        Map<String, Double> cityTransactionsMap = inputData.stream()
                .collect(Collectors.groupingBy(
                        obj -> obj.city(),
                        Collectors.summingDouble(obj -> obj.amount())
                ));
        Map<String, Double> result = cityTransactionsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .orElseGet(Map::of);

        return result;
    }

    public static void main(String[] args) {
        List<Transactions> transactions = List.of(
                new Transactions("T1", 1000.0, "ELECTRONICS", "New York"),
                new Transactions("T2", 500.0, "GROCERY", "Chicago"),
                new Transactions("T3", 700.0, "ELECTRONICS", "New York"),
                new Transactions("T4", 1200.0, "CLOTHING", "San Francisco"),
                new Transactions("T5", 800.0, "ELECTRONICS", "San Francisco")
        );

        System.out.println("City with max transactions is: " + cityWithMaxTransaction(transactions));
    }
}
