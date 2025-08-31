package practice.mathgeometry;

import java.util.Arrays;

public class RotateImageUsingCellsRotation {
    public static int[][] rotateImageByCells(int[][] inputMatrix){
        System.out.println("\nBefore Rotation: "+Arrays.deepToString(inputMatrix));

        int l=0;
        int r=inputMatrix.length-1;

        while(l<r){
            for(int i =0; i<r-l; i++){
                int top=l;
                int bottom=r;

                //save top-left
                int topLeft = inputMatrix[top][l+i];

                //move bottom-left to top-left
                inputMatrix[top][l+i] = inputMatrix[bottom-i][l];

                //move bottom-right to bottom-left
                inputMatrix[bottom-i][l] = inputMatrix[bottom][r-i];

                //move top=right to bottom-right
                inputMatrix[bottom][r-i] = inputMatrix[top+i][r];

                //move top-left to top-right
                inputMatrix[top+i][r] = topLeft;
            }
            r--;
            l++;
        }

        return inputMatrix;
    }
    public static void main(String[] args){
        int[][] inputMatrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println("After Rotation: "+Arrays.deepToString(rotateImageByCells(inputMatrix)));

        int[][] inputMatrix1 = new int[][]{
                {1,2},
                {3,4}
        };
        System.out.println("After Rotation: "+Arrays.deepToString(rotateImageByCells(inputMatrix1)));

        int[][] inputMatrix2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println("After Rotation: "+Arrays.deepToString(rotateImageByCells(inputMatrix2)));
    }
}
