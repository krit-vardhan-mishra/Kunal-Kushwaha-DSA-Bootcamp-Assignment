package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class ReverseLL {
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return temp;
    }
}
