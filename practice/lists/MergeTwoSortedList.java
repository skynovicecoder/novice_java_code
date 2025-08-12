package practice.lists;

public class MergeTwoSortedList {
    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(list1 != null && list2 !=null){
            if(list1.value < list2.value){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if(list1!=null){
            node.next = list1;
        }else if(list2!=null){
            node.next=list2;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(10)));
        ListNode list2 = new ListNode(3, new ListNode(8, new ListNode(12)));
        ListNode result = mergeTwoSortedList(list1, list2);
        System.out.println(result.toString());
    }
}
