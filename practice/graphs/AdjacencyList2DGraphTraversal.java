package practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyList2DGraphTraversal {
    static int rows,cols;
    public static void main(String[] args){
        /*String[][] grid = {
                {"0", "1", "1", "0", "0"},
                {"0", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };*/
        String[][] grid = {
                {"1","1","0","0","1"},
                {"1","1","0","0","1"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        rows = grid.length;
        cols = grid[0].length;
        int totalCells = rows * cols;

        //1 build adjacency list
        List<List<Integer>> adjList = buildAdjList(grid);

        /*//2. Check for the starting
        int startId=-1;
        for(int i=0;i<totalCells;i++){
            int r=i/cols, c=i%cols;
            if(grid[r][c].equals("1")){
                startId = i;
                break;
            }
        }
        if(startId==-1){
            System.out.println("There is no starting point");
            return;
        }*/

        //3. Start DFS
        boolean[] visitedDFS = new boolean[totalCells];
        System.out.println("DFS Traversal ---->>>> ");
        //dfs(adjList, visitedDFS, startId);
        int componentCountDFS = 0;
        for(int i =0; i<totalCells; i++){
            int r=i/cols, c=i%cols;
            if(grid[r][c].equals("1") && !visitedDFS[i]){
                System.out.println("Component " + (componentCountDFS + 1) + ":");
                dfs(adjList, visitedDFS, i);
                componentCountDFS++;
            }
        }
        System.out.println("\nTotal Connected Components (DFS): " + componentCountDFS + "\n");

        System.out.println(" ");

        //4. Start BFS
        boolean[] visitedBFS = new boolean[totalCells];
        System.out.println("BFS Traversal ---->>>> ");
        //bfs(adjList, visitedBFS, totalCells);
        int componentCountBFS = 0;
        for(int i =0; i<totalCells; i++){
            int r=i/cols, c=i%cols;
            if(grid[r][c].equals("1") && !visitedBFS[i]){
                System.out.println("Component " + (componentCountBFS + 1) + ":");
                bfs(adjList, visitedBFS, i);
                componentCountBFS++;
            }
        }
        System.out.println("\nTotal Connected Components (BFS): " + componentCountBFS);
    }

    //1. Build Adjecency list
    private static List<List<Integer>> buildAdjList(String[][] grid){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i<rows*cols; i++){
            adjList.add(new ArrayList<>());
        }

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //up, down, left,right

        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                int id = i*cols+j;

                for(int[] dir : dirs){
                    int ni= i+dir[0];
                    int nj= j+dir[1];
                    int nid = ni*cols+nj;
                    if(ni>=0 && nj>=0 && ni<rows && nj<cols && grid[ni][nj].equals("1")){
                        adjList.get(id).add(nid);
                    }
                }
            }

        }
        return adjList;

    }

    //2. DFS
    private static void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;
        printNode(node);

        for (int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(adj, visited, neighbour);
            }
        }
    }

    //3. BFS
    private static void bfs(List<List<Integer>> adj, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            printNode(node);

            for(int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

    }

    //4. print node
    private static void printNode(int node){
        int r=node/cols, c=node%cols;
        System.out.println("Node visited: "+node+" at ("+r+","+c+")");
    }
}
