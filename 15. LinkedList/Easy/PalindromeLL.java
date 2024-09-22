package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class PalindromeLL {

    public boolean isPalindrome(ListNode head) {
        if(head != null && head.next == null) return true;
    
        ListNode fast = head;
        ListNode slow = head;
    
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
    
            if(slow == fast) break;
        }
    
        ListNode temp = head;
        ListNode mid = slow;
        ListNode rev = reverseList(mid);
    
        while (temp != null && rev != null) {
            if(temp.val != rev.val) return false;
            temp = temp.next;
            rev = rev.next;
        }
    
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }

}
