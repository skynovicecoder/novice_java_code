package practice.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpriralMatrix {
    public static List<Integer> spriralMAtrix(int[][] inputMatrix){
        if(inputMatrix == null || inputMatrix.length==0 ) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int left=0, right=inputMatrix[0].length;
        int top=0, bottom=inputMatrix.length;

        while(left<right && top<bottom){
            for(int i=left; i<right; i++){
                output.add(inputMatrix[top][i]);
            }
            top++;

            for(int i=top; i<bottom; i++){
                output.add(inputMatrix[i][right-1]);
            }
            right--;

            if(!(left<right && top<bottom)){
                break;
            }

            for(int i = right-1; i>=left; i--){
                output.add(inputMatrix[bottom-1][i]);
            }
            bottom--;

            for(int i =bottom-1; i>= top; i--){
                output.add(inputMatrix[i][left]);
            }
            left++;
        }

        return output;
    }

    public static void main(String[] args){
        int[][] inputArray = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spriralMAtrix(inputArray));

        int[][] inputArray1 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(spriralMAtrix(inputArray1));

        int[][] inputArray2 = new int[][]{};
        System.out.println(spriralMAtrix(inputArray2));
    }
}
