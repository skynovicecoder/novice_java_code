package practice.graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node dfsCloneGraph(Node inputNode) {
        Map<Node, Node> cloneMap = new HashMap<>();
        return dfs(inputNode, cloneMap);
    }

    public Node dfs(Node inputNode, Map<Node, Node> cloneMap){
        if(inputNode == null){
            return null;
        }
        if(cloneMap.containsKey(inputNode)){
            cloneMap.get(inputNode);
        }

        Node clone = new Node(inputNode.val);
        cloneMap.put(inputNode, clone);

        for(Node neighbour: inputNode.neighbors){
            clone.neighbors.add(dfs(neighbour, cloneMap));
        }
        return  clone;
    }

}

 class CloneGraphBFS {
    public Node cloneGraphBFS(Node node){
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            for(Node neighbour : currentNode.neighbors){
                if(!oldToNew.containsKey(neighbour)) {
                    oldToNew.put(neighbour, new Node(neighbour.val));
                    queue.offer(neighbour);
                }
                oldToNew.get(currentNode).neighbors.add(oldToNew.get(neighbour));
            }
        }

        return oldToNew.get(node);
    }

}
