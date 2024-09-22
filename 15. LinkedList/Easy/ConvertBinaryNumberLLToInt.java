package Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;} 
}

public class ConvertBinaryNumberLLToInt {

    public static int getDecimalValue(ListNode head) {
        if(head == null) return 0;

        ListNode temp = head;
        int decimalValue = 0;

        while (temp != null) {
            decimalValue = decimalValue * 2 + temp.val;
            temp = temp.next;
        }

        return decimalValue;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.err.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(1);
        ListNode b = new ListNode(0, c);
        ListNode a = new ListNode(1, b);

        print(a);
        System.out.println(getDecimalValue(a));
    }
    
}