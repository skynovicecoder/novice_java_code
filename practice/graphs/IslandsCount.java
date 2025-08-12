package practice.graphs;

import java.util.*;

public class IslandsCount {
    public static void main(String[] args) {
        String[][] grid = {
                {"0", "1", "1", "1", "0"},
                {"0", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

        int rows = grid.length;
        int cols = grid[0].length;

        // Create an adjacency list for each cell
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // up, down, left, right

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].equals("1")) {
                    int currentId = i * cols + j;
                    adjList.putIfAbsent(currentId, new ArrayList<>());

                    // Check all 4 directions
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && grid[ni][nj].equals("1")) {
                            int neighborId = ni * cols + nj;
                            adjList.get(currentId).add(neighborId);
                        }
                    }
                }
            }
        }

        // Print the adjacency list
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print("Node " + entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
