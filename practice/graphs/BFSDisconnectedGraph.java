package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDisconnectedGraph {
    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, ArrayList<Integer> resultList){

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

    public static ArrayList<Integer> BFSDisconnected(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        for(int i=0; i< adj.size(); i++){
            if(!visited[i]) {
                BFS(adj, i, visited, result);
            }
        }

        return result;
    }

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(0)));
        adjList.add(new ArrayList<>(Arrays.asList(0)));
        adjList.add(new ArrayList<>(Arrays.asList(4)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(4)));

        ArrayList<Integer> result = BFSDisconnected(adjList);
        result.forEach(System.out::print);

    }
}
