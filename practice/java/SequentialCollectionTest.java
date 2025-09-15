package practice.java;

import java.util.*;

public class SequentialCollectionTest {

    public static void testList(){
        SequencedCollection<String> collectionObj = new ArrayList<>();
        collectionObj.addFirst("A");
        collectionObj.addFirst("B");
        collectionObj.addLast("C");

        System.out.println(collectionObj); //BAC
        collectionObj=collectionObj.reversed();
        System.out.println(collectionObj); //CAB
        collectionObj.removeLast();
        System.out.println(collectionObj); //CA
        collectionObj.removeFirst();
        System.out.println(collectionObj); //A
    }

    public static void testSet(){
        SequencedSet<String> setList = new LinkedHashSet<>();
        setList.addFirst("X");
        setList.addLast("A");
        setList.addFirst("B");
        System.out.println(setList); //BXA
        setList = setList.reversed();
        System.out.println(setList); //AXB
        setList.removeFirst();
        System.out.println(setList); //XB
        setList.removeLast();
        System.out.println(setList); //X
    }

    public static void testMap(){
        SequencedMap<String, String> mapList = new LinkedHashMap<>();
        mapList.putFirst("India", "Delhi");
        mapList.putLast("UP", "Varanasi");
        mapList.putFirst("MH", "Pune");

        System.out.println(mapList); //MH, India, UP
        mapList = mapList.reversed();  //Method specific to SequencedMap
        System.out.println(mapList); //UP, India, MH
        mapList.remove("UP");
        System.out.println(mapList); //India, MH
        mapList.remove("MH");
        System.out.println(mapList); //India

        mapList.putFirst("UP","Varanasi");
        System.out.println(mapList); //UP, India
        mapList.putLast("MH","Pune");
        System.out.println(mapList); //UP, India, MH
        System.out.println(mapList.firstEntry()); //UP  //Method specific to SequencedMap
        System.out.println(mapList); //UP, India, MH
        System.out.println(mapList.pollLastEntry()); //MH
        System.out.println(mapList); //UP, India
        System.out.println(mapList.pollFirstEntry()); //UP //Method specific to SequencedMap
        System.out.println(mapList); //India
    }

    public static void main(String[] args){

        //testList();
        //testSet();
        testMap();
    }
}
