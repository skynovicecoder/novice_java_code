package practice.listarrays;

public class LocalMaxima {

    public static int findLocalMaxima(int[] inputArray){
        int low=0,high=inputArray.length-1;
        while(low<=high){
            //int mid = (low+high)/2;
            int mid = low+(high-low)/2;

            if(inputArray[mid] > inputArray[mid+1] && inputArray[mid] > inputArray[mid-1]){
                return inputArray[mid];
            }
            if(mid< inputArray.length-1 && inputArray[mid] <= inputArray[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return -1;
    }

    public static void main(String[] args){
        int[] inputArray = {1, 3, 20, 4, 1, 0};
        System.out.println(findLocalMaxima(inputArray));
    }
}
