package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class MergeTwoSortedLL {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null) temp.next = l1;
        else temp.next = l2;

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
        ListNode c1 = new ListNode(4);
        ListNode b1 = new ListNode(2, c1);
        ListNode a1 = new ListNode(1, b1);

        ListNode c2 = new ListNode(4);
        ListNode b2 = new ListNode(3, c2);
        ListNode a2 = new ListNode(1, b2);

        print(a1);
        print(a2);
        print((mergeTwoLists(a1, a2)));
    }
}
