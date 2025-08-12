package practice.sorting;

import java.util.Arrays;

public class PigeonSort {

    public static void pigenhole_sort(int[] arr, int size){
    int max = arr[0], min=arr[0];
        for(int i =0;i<arr.length; i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("min: "+min+" :max: "+max);
        int range = max-min+1;

        int[] phole = new int[range];

        for(int i=0; i < phole.length; i++){
            phole[arr[i] - min]++;
        }
        System.out.println(Arrays.toString(phole));

        int index=0;
        for(int j =0;j<range;j++) {
            while (phole[j]>0){
                phole[j]--;
                arr[index++]=j+min;
            }
        }

    }

    public static void main(String[] args){

        int[] inputData = {8, 3, 2, 7, 4, 6, 8};
        pigenhole_sort(inputData, inputData.length);
        for(int data: inputData){
            System.out.println(data);
        }

    }
}
