package practice.lists;

public class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    ListNode(ListNode next) {
        this.next = next;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
