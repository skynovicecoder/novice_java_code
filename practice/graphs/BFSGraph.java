package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj, int source){
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> resultList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()){
            int front = queue.poll();
            resultList.add(front);

            for(int i : adj.get(front)){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(1,4)));
        adjList.add(new ArrayList<>(Arrays.asList(2,3)));

        ArrayList<Integer> result = BFS(adjList, 0);
        result.forEach(System.out::print);

    }
}
