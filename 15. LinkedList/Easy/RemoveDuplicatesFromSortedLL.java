package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class RemoveDuplicatesFromSortedLL {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;

        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            
            temp = temp.next;
        }

        return head;
    }
}
