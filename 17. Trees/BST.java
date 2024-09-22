public class BST {

    BST() {}

    public class Node {
        private int value, height;
        private Node left, right;

        public Node(int item) {
            value = item;
        }
        
        public int getValue() {
            return value;
        }
    }

    private Node root;
    
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void insert(int[] nums) {
        if(isSorted(nums)) {
            insert(nums, 0, nums.length);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void insert(int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        insert(nums, start, mid);
        insert(nums, mid+1, end);
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    public int height(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    // public void print() {
    //     print(root, "Root Node : ");
    // }

    // private void print(Node node, String prefix) {
    //     if (node == null)
    //         return;
        
    //     System.out.println(prefix + node.getValue());

    //     print(node.left, "Left Child of "+node.getValue()+" : ");
    //     print(node.right, "Right Child of "+node.getValue()+" : ");
    // }
    
    // public void display() {
    //   display(root, 0);
    // }

    // private void display(Node node, int level) {
    //   if (node == null) {
    //     return;
    //   }

    //   display(node.right, level + 1);

    //   if (level != 0) {
    //     for (int i = 0; i < level - 1; i++) {
    //       System.out.print("|\t  ");
    //     }
    //     System.out.println("|------->" + node.value+"|");
    //   } else {
    //     System.out.println(node.value);
    //   }
    //   display(node.left, level + 1);
    // }

    void print() {
        System.out.println("┌─────────── ");
        System.out.println("│ Tree Start ");
        System.out.println("│   ");
        print(this.root, "", false);
    }

    private void print(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            print(node.left, prefix + (isLeft ? "│   " : "    "), true);
            print(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
