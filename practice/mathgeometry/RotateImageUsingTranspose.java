package practice.mathgeometry;

import java.util.Arrays;

public class RotateImageUsingTranspose {
    public static int[][] rotateImageByNinety(int[][] inputMatrix){
    reverseMatrix(inputMatrix);

    for(int i=0; i<inputMatrix.length;i++){
        for(int j=i; j<inputMatrix[0].length;j++){
            int temp = inputMatrix[i][j];
            inputMatrix[i][j] = inputMatrix[j][i];
            inputMatrix[j][i] = temp;
        }
    }
    return inputMatrix;
    }

    public static void reverseMatrix(int[][] matrix){
        System.out.println("\nBefore Reverse: "+Arrays.deepToString(matrix));
        int length = matrix.length;
        for(int i=0; i<length/2; i++){
            int[] tempArray = matrix[i];
            matrix[i] = matrix[length-1-i];
            matrix[length-1-i] = tempArray;
        }
        System.out.println("After Reverse: "+Arrays.deepToString(matrix));
        //return matrix;
    }

    public static void main(String[] args){
        int[][] inputMatrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.deepToString(rotateImageByNinety(inputMatrix)));

        int[][] inputMatrix1 = new int[][]{
                {1,2},
                {3,4}
        };
        System.out.println(Arrays.deepToString(rotateImageByNinety(inputMatrix1)));

        int[][] inputMatrix2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(Arrays.deepToString(rotateImageByNinety(inputMatrix2)));
    }
}
