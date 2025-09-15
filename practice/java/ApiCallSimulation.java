package practice.java;
import java.util.*;

public class ApiCallSimulation {

    public static List<String> simulateApiCall() {
        Random rand = new Random();
        long total = 0;

        // Generate random numbers & sum squares directly
        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(10000);
            total += num * num;
        }

        /*// Prepare map
        Map<String, String> data = new HashMap<>(1000);
        for (int i = 0; i < 1000; i++) {
            data.put("key_" + i, "value_" + i);
        }

        // Prepare result strings efficiently
        List<String> resultStrings = new ArrayList<>(1000);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            resultStrings.add("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }*/

        List<String> resultStrings = new ArrayList<>(1000);
        StringBuilder sb = new StringBuilder(40);
        for (int i = 0; i < 1000; i++) {
            //resultStrings.add("Key: key_" + i + ", Value: value_" + i);
            sb.setLength(0); // reset StringBuilder without creating new object
            sb.append("Key: key_")
                    .append(i)
                    .append(", Value: value_")
                    .append(i);
            resultStrings.add(sb.toString());
        }

        // Simulate a bit of CPU work (once, not 1000 times per key)
        /*int temp = 0;
        for (int j = 0; j < 1000000; j++) {
            temp += j;
        }*/

        int n = 1000000;
        int temp = n*(n-1)/2;

        if (total == 0) {
            System.out.println("Sanity check");
        }

        return resultStrings;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        List<String> results = simulateApiCall();

        long end = System.currentTimeMillis();
        long endMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Processed " + results.size() + " key-value pairs");
        System.out.println("Time taken: " + (end - start) + "ms");
        System.out.println("Approx memory used: " + (endMem - startMem) / 1024 + " KB");
    }
}
