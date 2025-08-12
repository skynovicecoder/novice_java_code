package practice.lists;

public class NodeListReversal {
    /*public ListNode reverseList(ListNode head){
        if (head == null) {
            return null;
        }
        // 1 -> 2 -> null
        ListNode newHead = head;
        if(head.next != null){
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }*/

    public static ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }

        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            ListNode temp =current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    public static void main(String[] args){
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,null))));
        System.out.println(list);
        ListNode result = reverseList(list);
        System.out.println(result);
    }

}
