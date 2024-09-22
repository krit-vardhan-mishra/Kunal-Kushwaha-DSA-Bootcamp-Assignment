class ListNode {
    int val; 
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode l1, l2, l3;
        for(int i=1; i<length; i <<= 1) {
            curr = temp.next;
            l3 = temp;
            while (curr != null) {
                l1 = curr;
                l2 = split(l1, i);
                curr = split(l2, i);
                l3 = merge(l1, l2, l3);
            }
        }

        return temp.next;
    }

    private ListNode split(ListNode head, int n) {
        for (int i = 1; head != null && i < n; i++) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode tail) {
        ListNode curr = tail;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        while (curr.next != null) curr = curr.next;
        return curr;
    }

    public static void main(String[] args) {
        
    }
}
