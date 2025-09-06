package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodes {
    int data;
    TreeNodes leftNode;
    TreeNodes rightNode;

    TreeNodes(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    /*TreeNodes(int data, TreeNodes leftNode, TreeNodes rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }*/

    @Override
    public String toString() {
        TreeNodes current = this;
        return String.valueOf(current.data);
    }
}

public class LeftMostNodeFromEachLevel {

    public static List<TreeNodes> findLeftMostNodes(TreeNodes root){
        List<TreeNodes> output = new ArrayList<>();

        Queue<TreeNodes> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNodes node = queue.poll();
                if(i==0){
                    output.add(node);
                }
                if(node.leftNode!=null) queue.add(node.leftNode);
                if(node.rightNode!=null) queue.add(node.rightNode);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNodes root = new TreeNodes(1);
        TreeNodes first = new TreeNodes(2);
        TreeNodes second = new TreeNodes(3);
        TreeNodes third = new TreeNodes(4);
        TreeNodes fourth = new TreeNodes(5);
        TreeNodes fifth = new TreeNodes(6);
        TreeNodes sixth = new TreeNodes(7);

        root.leftNode = first;
        root.rightNode = second;

        first.leftNode = third;
        first.rightNode = fourth;

        second.leftNode = fifth;
        second.rightNode = sixth;

        System.out.println("1. Tree Left Most Nodes From Each Level :: "+findLeftMostNodes(root));

        TreeNodes root1 = new TreeNodes(1);
        TreeNodes first1 = new TreeNodes(2);
        TreeNodes second1 = new TreeNodes(3);
        TreeNodes fifth1 = new TreeNodes(4);
        TreeNodes sixth1 = new TreeNodes(5);

        root1.leftNode = first1;
        root1.rightNode = second1;

        second1.leftNode = fifth1;

        fifth1.rightNode = sixth1;

        System.out.println("2. Tree Left Most Nodes From Each Level :: "+findLeftMostNodes(root1));

    }

}
