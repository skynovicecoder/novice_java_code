package practice.lists;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        Node current = this;
        StringBuilder builder = new StringBuilder();
        while (current != null) {
            builder.append(current.data);
            if (current.next != null) {
                builder.append("-->");
            }
            current = current.next;
        }
        return builder.toString();
    }
}

public class NthNodeFromLast {
    public static Node findNthLastNode(Node head, int n) {
        if (head == null) return null;

        Node first = head;
        Node second = head;

        //Give first head start of n
        for (int i = 0; i < n; i++) {
            if (first == null) return null;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void main(String[] args) {
        int n = 2;
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node last = new Node(6);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = last;
        last.next = null;


        System.out.println("Input :: "+head.toString()+" :: Looking for "+n+" from last");
        System.out.println(findNthLastNode(head, n) != null ? findNthLastNode(head, n).toString() : findNthLastNode(head, n));

        int n1=8;
        System.out.println("Second Input :: "+head.toString()+" :: Looking for "+n1+" from last");
        System.out.println(findNthLastNode(head, n1) != null ? findNthLastNode(head, n1).toString() : findNthLastNode(head, n1));

    }
}
