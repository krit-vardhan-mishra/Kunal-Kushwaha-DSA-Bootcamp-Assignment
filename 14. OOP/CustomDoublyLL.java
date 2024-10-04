

public class CustomDoublyLL {
    private Node head;
    private int size;

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public CustomDoublyLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }

        head = node;
        size++;
    }

    public void insert(int value) {
        Node node = new Node(value);
        Node last = head;

        node.next = null;
        
        if(head == null) {
            node.prev = null;
            head = node;
            size++;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if(index == size) {
            insert(value);
            size++;
            return;
        }

        Node temp = get(index-1);
        Node node = new Node(value, temp, temp.next);
        temp.next = node;
        temp.next.next.prev = node;

        size++;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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

    public Node arrToList(int[] arr) {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], temp, null);
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }

    public void display() {
        Node temp = head;
        Node lead = null;
        System.out.print("Forward List : Start -> ");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            lead = temp;
            temp = temp.next;
        }
        System.out.println("End.");

        System.out.print("Reverse List : End -> ");
        while(lead != null) {
            System.err.print(lead.value + " -> ");
            lead = lead.prev;
        }
        System.out.println("Start.");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        CustomDoublyLL list = new CustomDoublyLL();
        list.arrToList(arr);
        // list.insertFirst(5);
        // list.insertFirst(4);
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(1);
        // list.insertAt(5, 6);
        list.display();
    }
}
