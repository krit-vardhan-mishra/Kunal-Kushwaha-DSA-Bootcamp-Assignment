class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();

        while (head != null) {
            ListNode next = head.next;
            ListNode temp = dummy;

            while (temp.next != null && temp.next.val < head.val) {
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;
            head = next;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode d = new ListNode(3);
        ListNode c = new ListNode(1, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(4, b);

        print(a);
        print(insertionSortList(a));
    }
    
}
