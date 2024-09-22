
public class Heap {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            right = left = null;
        }
    }

    private Node root;

    public Heap() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value <= root.val) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);

        return root;
    }

    // Checking if the given Heap is Max or not
    public boolean isMaxHeap() {
        return isMaxHeap(root);
    }

    private boolean isMaxHeap(Node root) {
        if (root == null) return true;
    
        boolean leftCheck = true;
        boolean rightCheck = true;
    
        if (root.left != null) {
            leftCheck = root.val >= root.left.val && isMaxHeap(root.left);
        }
    
        if (root.right != null) {
            rightCheck = root.val >= root.right.val && isMaxHeap(root.right);
        }
    
        return leftCheck && rightCheck;
    }

    // Checking if the given Heap is Min or not
    public boolean isMinHeap() {
        return isMinHeap(root);
    }
    private boolean isMinHeap(Node root) {
        if (root == null) return true;
    
        boolean leftCheck = true;
        boolean rightCheck = true;
    
        if (root.left != null) {
            leftCheck = root.val <= root.left.val && isMinHeap(root.left);
        }

        if (root.right != null) {
            rightCheck = root.val <= root.right.val && isMinHeap(root.right);
        }
    
        return leftCheck && rightCheck;
    }

    void printHeap(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printHeap(root.left);
        printHeap(root.right);
    }

    void print() {
        System.out.println("┌─────────── ");
        System.out.println("│ Heap Start ");
        System.out.println("│   ");
        print(this.root, "");
    }

    private void print(Node node, String prefix) {
        if (node != null) {
            System.out.println(prefix + ("└── ") + node.val);
            print(node.left, prefix + ("    "));
            print(node.right, prefix + ("    "));
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);

        System.out.println("Heap elements:");
        heap.printHeap(heap.root);
        System.out.println();
        System.out.println();
        heap.print();

        System.out.println("\nIs Max Heap? " + heap.isMaxHeap());
        System.out.println("Is Min Heap? " + heap.isMinHeap());
    }
}
