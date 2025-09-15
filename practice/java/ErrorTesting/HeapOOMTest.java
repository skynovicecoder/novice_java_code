package practice.java.ErrorTesting;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest {

    public static void main(String[] args){
        List<byte[]> byteList = new ArrayList<>();

        try{
            while(true){
                byteList.add(new byte[10_000_000]);
                System.out.println("byte List Size : "+byteList.size());
            }
        }catch (OutOfMemoryError err){
            System.out.println("Out of Memory Error: "+err.getMessage());
        }

    }

}
