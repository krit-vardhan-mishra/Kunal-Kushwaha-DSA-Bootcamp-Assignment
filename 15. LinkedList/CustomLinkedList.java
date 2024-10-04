
public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public CustomLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insert(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insert(value);
            return;
        }

        Node temp = get(index - 1);
        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    public void insertRecursion(int value, int index) {
        head = insertRec(value, index, head);
    }

    private Node insertRec(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRec(value, index - 1, node.next);
        return node;
    }

    public int size() {
        return this.size;
    }

    public void insertAll(CustomLinkedList l1) {
        if (l1 == null || l1.head == null)
            return;

        if (this.head == null) {
            this.head = l1.head;
            this.tail = l1.tail;
            this.size = l1.size;
        } else {
            this.tail.next = l1.head;
            this.tail = l1.tail;
            this.size += l1.size;
        }
    }

    // Not prefered this method as it creating a new CustomLinkedList.
    public static CustomLinkedList insertAll(CustomLinkedList l1, CustomLinkedList l2) {
        CustomLinkedList ans = new CustomLinkedList();

        // inserting First LinkedList.
        ans.head = l1.head;
        ans.tail = l1.tail;

        // inserting Second LinkedList.
        ans.tail.next = l2.head;
        ans.tail = l2.tail;
        ans.tail.next = null;

        return ans;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void deleteFirst() {
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        System.out.println("Deleted Element is : " + value);
    }

    public void deleteLast() {
        if (size <= 1) {
            deleteFirst();
            return;
        }

        Node secLast = get(size - 2);
        int value = tail.value;
        tail = secLast;
        tail.next = null;

        size--;
        System.out.println("Deleted Element is : " + value);
    }

    public void deleteAt(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node previous = get(index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next;

        size--;

        System.out.println("Deleted Element at Index " + index + " : " + value);
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void deleteDuplicates() {
        Node temp = head;
        while (temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    public boolean contains(int val) {
        Node temp = head;

        while (temp != null) {
            if (temp.value == val)
                return true;
            else
                temp = temp.next;
        }

        return false;
    }

    public static CustomLinkedList mergeSort(CustomLinkedList l1, CustomLinkedList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;

        CustomLinkedList ans = new CustomLinkedList();

        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                ans.insert(n1.value);
                n1 = n1.next;
            } else {
                ans.insert(n2.value);
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            ans.insert(n1.value);
            n1 = n1.next;
        }

        while (n2 != null) {
            ans.insert(n2.value);
            n2 = n2.next;
        }

        return ans;
    }

    public void mergeSort(CustomLinkedList l2) {
        Node n1 = this.head;
        Node n2 = l2.head;

        CustomLinkedList ans = new CustomLinkedList();

        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                ans.insert(n1.value);
                n1 = n1.next;
            } else {
                ans.insert(n2.value);
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            ans.insert(n1.value);
            n1 = n1.next;
        }

        while (n2 != null) {
            ans.insert(n2.value);
            n2 = n2.next;
        }

        this.head = null;
        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;
    }

    public void clear() {
        this.head = null;
    }

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    public static int cycleLength(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                Node len = slow;
                int length = 0;
                do {
                    len = len.next;
                    length++;
                } while (len != slow);
                return length;
            }
        }

        return -1;
    }

    public static Node detectCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = cycleLength(slow);
                break;
            }
        }

        if (length == 0)
            return null;

        Node first = head;
        Node second = head;

        while (length > 0) {
            second = second.next;
            length--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    
    private Node getMiddle(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void sort() {
        if (this.head != null) {
            CustomLinkedList sortedList = sortList(this.head);
            this.head = sortedList.head;
            this.tail = sortedList.tail;
            this.size = sortedList.size;
        }
    }

    private CustomLinkedList sortList(Node head) {
        if (head == null || head.next == null) {
            CustomLinkedList base = new CustomLinkedList();
            if (head != null) {
                base.insert(head.value);
            }
            return base;
        }

        Node mid = getMiddle(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        CustomLinkedList leftList = sortList(leftHead);
        CustomLinkedList rightList = sortList(rightHead);

        return mergeSortedList(leftList, rightList);
    }

    public CustomLinkedList mergeSortedList(CustomLinkedList l1, CustomLinkedList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;

        CustomLinkedList ans = new CustomLinkedList();

        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                ans.insert(n1.value);
                n1 = n1.next;
            } else {
                ans.insert(n2.value);
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            ans.insert(n1.value);
            n1 = n1.next;
        }

        while (n2 != null) {
            ans.insert(n2.value);
            n2 = n2.next;
        }

        return ans;
    }

    public void reverseRecursion(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void reverseIterative() {
        if(size < 2) return;

        Node present = head;
        Node prev = null;
        Node next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) next  = next.next;
        }
        
        head = prev;
    }
    
    public Node reverseList(Node head) {
        if(head == null) return head;

        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
     
    public Node reverseBetween(Node head, int right, int left) {
        if(left == right) return head;

        Node curr = head;
        Node prev = null;
        
        for(int i=0; curr != null && i < left - 1;i ++) {
            prev = curr;
            curr = curr.next;
        }

        Node last = prev;
        Node newEnd = curr;

        Node next = curr.next;
        for(int i=0; curr != null && i < right-left+1;i++) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null) last.next = prev;
            else head = prev;
        }

        newEnd.next = curr;

        return head;
    }
        
    public boolean isPalindrome() {
        Node mid = middleNode(head);
        Node headSec = reverseList(mid);
        Node reverseHead = headSec;
        
        while (head != null && headSec != null) {
            if(head.value != headSec.value) break;
            head = head.next;
            headSec = headSec.next;
        }
        reverseList(reverseHead);

        return head == null || headSec == null;
    }

    public void reorderList(Node head) {
        Node headFirst = head;
        Node mid = middleNode(head);
        Node halfSec = reverseList(mid);
        
        while (headFirst != null && halfSec != null) {
            Node temp = headFirst.next;
            headFirst.next = halfSec;
            headFirst = temp;
            temp = halfSec.next;
            halfSec.next = headFirst;
            halfSec = temp;
        }

        if(headFirst != null) headFirst.next = null;
    }

    public static int getDecimal(Node head) {
        int decVal = 0;
        Node temp = head;
        while(temp != null) {
            decVal = (decVal << 1) | temp.value;
            temp = temp.next;
        }
        return decVal;
    }

    public void reverse(Node node) {
        if(size < 2) return;

        Node present = node;
        Node prev = null;
        Node next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) next  = next.next;
        }
        
        head = prev;
    }

    public void display() {
        if (this.head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        System.out.print("Forward : ");
        System.out.print("Start -> ");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End.");
    }

    public static void main(String[] args) {
        // LinkedList
        CustomLinkedList ll1 = new CustomLinkedList();
        ll1.insert(3);
        ll1.insert(2);
        ll1.insert(0);
        ll1.insert(-4);
        ll1.display();
        System.out.println(detectCycle(ll1.head.next));

        // ll1.insert(10);
        // ll1.insert(23);
        // ll1.insert(45);
        // ll1.sort();
        // ll1.display();

        // CustomLinkedList ll2 = new CustomLinkedList();
        // ll2.insert(30);
        // ll2.insert(9);
        // ll2.insert(23);
        // ll2.insert(0);
        // ll2.insert(3);
        // ll2.sort();

        // ll1.insertAll(ll2);
        // ll1.display();

        // ll1.sort();
        // ll1.display();
        // ll1.reverseRecursion(ll1.head);
        // ll1.display();
        // ll1.reverseIterative();
        // ll1.display();
        // ll1.reorderList(ll1.head);
        // ll1.display();
        // Node temp = ll1.middleNode(ll1.head);
        // System.out.println(temp.value);
    }
}
