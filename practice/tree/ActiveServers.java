package practice.tree;

import java.util.*;

public class ActiveServers {

    public static int getMaxTrafficTime(List<Integer> start, List<Integer> stop) {
        TreeMap<Integer, Integer> numberOfServersActivePerSecond = new TreeMap<>();

        for(int startTime : start){
            numberOfServersActivePerSecond.put(startTime, numberOfServersActivePerSecond.getOrDefault(startTime,0)+1);
        }
        System.out.println(numberOfServersActivePerSecond);
        for(int stopTime : stop){
            numberOfServersActivePerSecond.put(stopTime+1, numberOfServersActivePerSecond.getOrDefault(stopTime+1, 0)-1);
        }

        System.out.println(numberOfServersActivePerSecond);

        int peakTime = 0;
        int currentRunning = 0;
        int maxRunning = 0;

        for(Map.Entry<Integer, Integer> map : numberOfServersActivePerSecond.entrySet()){
            currentRunning = currentRunning+map.getValue();
            if(currentRunning > maxRunning){
                peakTime = map.getKey();
                maxRunning = currentRunning;
            }
        }

        System.out.println(maxRunning);
        return peakTime;
    }

    public static void main(String[] args){
        System.out.println(getMaxTrafficTime(Arrays.asList(1, 6, 3, 5, 9), Arrays.asList(3,9,8,7,10)));
    }
}
