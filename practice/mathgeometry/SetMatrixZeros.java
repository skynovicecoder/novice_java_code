package practice.mathgeometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {
    //Time Complexity O(mn)
    //Space complexity O(m+n)
    public static int[][] setMatrixToZeros(int[][] inputArray) {
        System.out.println("\nInput Array " + Arrays.deepToString(inputArray));
        if (inputArray.length == 0) return new int[][]{};

        int rows = inputArray.length;
        int cols = inputArray[0].length;
        boolean[] rowZero = new boolean[rows];
        boolean[] colZero = new boolean[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (inputArray[r][c] == 0) {
                    rowZero[r] = true;
                    colZero[r] = true;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rowZero[r] || colZero[c]) {
                    inputArray[r][c] = 0;
                }
            }
        }
        return inputArray;
    }

    //Time complexity : Best O(m.n+k(m+n)) ~ O(m.n) if k is small
    //Worst case is very high O(m.n(m+n))
    /*public static int[][] setMatrixToZeros(int[][] inputArray) {
        System.out.println("\nInput Array "+Arrays.deepToString(inputArray));

        if(inputArray.length==0) return new int[][]{};

        List<int[]> targetPoints = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[0].length; j++) {
                if (inputArray[i][j] == 0) {
                    targetPoints.add(new int[]{i, j});
                }
            }
        }
        System.out.println("Found points with Zero: "+Arrays.deepToString(targetPoints.toArray()));

        List<int[][]> directions = List.of(
                new int[][]{{0, -1}}, //left
                new int[][]{{0, 1}}, //right
                new int[][]{{-1, 0}}, //top
                new int[][]{{1, 0}} //down
        );

        for (int[] coordinates : targetPoints) {
            int row = coordinates[0];
            int col = coordinates[1];

            //go left
            for (int i = col; i > 0; i--) {
                inputArray[row][i - 1] = 0;
            }
            //go right
            for(int i=col;i<inputArray[0].length-1;i++){
                inputArray[row][i+1]=0;
            }

            //go top
            for(int i=row;i>0;i--){
                inputArray[i-1][col]=0;
            }

            //go bottom
            for(int i=row;i<inputArray.length-1;i++){
                inputArray[i+1][col]=0;
            }

        }

        return inputArray;
    }*/

    public static void main(String[] args) {
        int[][] inputArray = new int[][]{
                {0, 1},
                {1, 0}
        };
        System.out.println(Arrays.deepToString(setMatrixToZeros(inputArray))); //[[0,0],[0,0]]

        int[][] inputArray2 = new int[][]{
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8}
        };
        System.out.println(Arrays.deepToString(setMatrixToZeros(inputArray2))); //[[1,0,3],[0,0,0],[6,0,8]]

        int[][] inputArray3 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(setMatrixToZeros(inputArray3))); //[[1,0,1],[0,0,0],[1,0,1]]

        int[][] inputArray4 = new int[][]{};
        System.out.println(Arrays.deepToString(setMatrixToZeros(inputArray4))); //[]


    }
}
