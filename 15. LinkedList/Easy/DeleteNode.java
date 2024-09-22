package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
