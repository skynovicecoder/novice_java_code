package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value=value;
    }

}
public class TreeTraversal {
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                System.out.print(node.value+" ");

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        levelOrderTraversal(root);
    }

}
