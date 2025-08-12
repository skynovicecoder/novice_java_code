package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APOcean {
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c]=true;

        for(int[] dir : dirs){
            int nr= r+dir[0], nc=c+dir[1];
            if(nr>=0 && nr<heights.length
                    && nc>=0 && nc<heights[0].length
                    && !ocean[nr][nc]
                    && heights[nr][nc] >= heights[r][c]){
                    dfs(nr, nc, ocean, heights);
            }
        }
    }
    public static void main(String[] args){

        int[][] heights = {
                {4,2,7,3,4},
                {7,4,6,4,7},
                {6,3,5,3,6}
        };

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c=0; c<cols; c++){
            dfs(0,c,pacific,heights);
            dfs(rows-1,c,atlantic,heights);
        }

        for(int r=0; r<rows; r++){
            dfs(r,0,pacific,heights);
            dfs(r,cols-1,atlantic,heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        System.out.println(result.toString());
    }
}
