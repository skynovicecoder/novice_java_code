package practice.listarrays;

import java.util.*;

public class RelativeSort {

    public static List<Integer> sortRelatively(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int num : arr1) {
            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            if (mapCount.containsKey(num)) {
                for (int i = 0; i < mapCount.get(num); i++) {
                    resultList.add(num);
                }
                mapCount.remove(num);
            }
        }
        List<Integer> remainList = new ArrayList<>(mapCount.keySet());
        Collections.sort(remainList);
        System.out.println("Sorted remain list :" + remainList);

        resultList.addAll(remainList);

        return resultList;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] arr2 = {2, 1, 8, 3};
        System.out.println(sortRelatively(arr1, arr2));
    }
}
