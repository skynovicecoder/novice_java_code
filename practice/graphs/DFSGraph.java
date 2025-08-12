package practice.graphs;

import java.util.ArrayList;

public class DFSGraph{

    public static void recursiveDFS(ArrayList<ArrayList<Integer>>  adj, boolean[] visited, int source, ArrayList<Integer> result){
        visited[source]=true;
        result.add(source);

        for(int destination : adj.get(source)){
            if(!visited[destination]){
                recursiveDFS(adj, visited, destination, result);
            }
        }
    }

    public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>>  adj){
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        //Step 4: Call the recursive DFS

        ////For Connected graph
        ////recursiveDFS(adj, visited, 0, result);

        //for disconnected graph
        for(int sourceIndex=0; sourceIndex < adj.size(); sourceIndex++){
            if(!visited[sourceIndex]) {
                recursiveDFS(adj, visited, sourceIndex, result);
            }
        }

        return result;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int target){
        adj.get(source).add(target);
        adj.get(target).add(source);
    }

    public static void main(String [] args){
        ////For Connected graph
        ////int vertexCount = 5;

        //for disconnected graph
        int vertexCount = 6;
        ArrayList<ArrayList<Integer>>  adjacencyList = new ArrayList<>();

        //Step 1 , initialize the adjacency list
        for(int i =0 ; i < vertexCount ; i++){
            adjacencyList.add(new ArrayList<>());
        }

        ////For Connected graph
        ////int[][] edgesData= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };

        //for disconnected graph
        int[][] edgesData= { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };
        //Step 2, add edges to the adjacency list
        for(int[] edgeArray: edgesData) {
            addEdge(adjacencyList, edgeArray[0], edgeArray[1]);
        }

        //Step 3: Call the DFS
        ArrayList<Integer> resultVertex = DFS(adjacencyList);
        //resultVertex.forEach(vertex -> System.out.println(vertex));
        resultVertex.forEach(System.out::print);

    }
}