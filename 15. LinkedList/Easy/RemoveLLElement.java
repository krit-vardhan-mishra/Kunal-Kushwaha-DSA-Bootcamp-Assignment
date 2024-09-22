class ListNode {
    int val;
    ListNode next;

    ListNode() {};
    ListNode(int val) {this.val = val; this.next = null;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class RemoveLLElement {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;

        while (temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummyNode.next;
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
        ListNode g = new ListNode(6);
        ListNode f = new ListNode(5, g);
        ListNode e = new ListNode(4, f);
        ListNode d = new ListNode(3, e);
        ListNode c = new ListNode(6, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        print(a);
        print((removeElements(a, 6)));
    }
}