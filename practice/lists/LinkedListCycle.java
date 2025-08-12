package practice.lists;

public class LinkedListCycle {

    /*public static boolean hasCycle(ListNode head){
        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while(current!=null){
            if(seen.contains(current)){
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }*/

    public static boolean hasCycle(ListNode head){
        ListNode fast= head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; //Note here cycle is introduced
        //node4.next = null;
        //System.out.println(node1); // This will give heap space error

        System.out.println("Given List has cycle is : "+hasCycle(node1));
    }
}