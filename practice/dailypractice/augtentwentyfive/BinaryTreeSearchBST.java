package practice.dailypractice.augtentwentyfive;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}

class InfoBST{
    boolean isBST; //Is BST  or not
    int size; //Current Size of the BST
    int min, max; //Min and Max in the BST
    Node root; //Root Node of the Current BST
    int largestBSTSize; //Current Max BST in the given Binary Tree

    InfoBST(boolean isBST, int size, int min, int max, Node root, int largestBSTSize){
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
        this.root = root;
        this.largestBSTSize = largestBSTSize;
    }
}

public class BinaryTreeSearchBST {
    public static InfoBST findMaxBST(Node node){
        if(node==null){
            return new InfoBST(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, null, 0);
        }

        InfoBST leftBSTTree = findMaxBST(node.left);
        InfoBST rightBSTTree = findMaxBST(node.right);

        if(leftBSTTree.isBST
                && rightBSTTree.isBST
                && node.val > leftBSTTree.max
                && node.val < rightBSTTree.min
        ){
            int currSize = leftBSTTree.size+ rightBSTTree.size+1;
            return new InfoBST(true,
                    currSize,
                    Math.min(node.val, leftBSTTree.min),
                    Math.max(node.val, rightBSTTree.max),
                    node,
                    currSize);
        }else{
            if(leftBSTTree.largestBSTSize >= rightBSTTree.largestBSTSize){
                return new InfoBST(false,0,0,0, leftBSTTree.root, leftBSTTree.largestBSTSize);
            }else{
                return new InfoBST(false,0,0,0, rightBSTTree.root, rightBSTTree.largestBSTSize);
            }
        }
    }
    public static void main(String[] args){
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        InfoBST result = findMaxBST(root);
        System.out.println("Size of largest BST: " + result.largestBSTSize);
        System.out.println("Root of largest BST: " + (result.root != null ? result.root.val : "null"));
    }
}
