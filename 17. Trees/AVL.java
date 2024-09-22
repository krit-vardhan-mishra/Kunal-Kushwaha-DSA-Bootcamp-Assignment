
public class AVL {
    class Node {
        private int value, height;
        Node right, left;

        Node (int value) {
            this.value = value;
            this.height = 0;
        }

        int getValue() {
            return value;
        }
    }

    private Node root;

    void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (getBalance(node) > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (getBalance(node) > 1 && getBalance(node.right) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (getBalance(node) < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        if (getBalance(node) < -1 && getBalance(node.right) > 0) {
            node.left = rightRotate(node.left);
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node node) {
        Node change = node.left;
        Node temp= change.right;

        change.right = node;
        node.left = temp;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        change.height = Math.max(height(change.left), height(change.right)) + 1;

        return change;
    }

    private Node leftRotate(Node node) {
        Node change = node.right;
        Node temp = change.left;

        change.left = node;
        node.right = temp;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        change.height = Math.max(height(change.left), height(change.right)) + 1;

        return change;
    }

    int height() {
        return height(root);
    }

    int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return node == null ? true : Math.abs(getBalance(node)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    // public void display() {
    //     display(root, 0);
    // }
  
    // private void display(Node node, int level) {
    //     if (node == null) {
    //         return; 
    //     }
  
    //     display(node.right, level + 1);
  
    //     if (level != 0) {
    //         for (int i = 0; i < level - 1; i++) {
    //             System.out.print("|\t  ");
    //         }
    //         System.out.println("|------->" + node.value+"|");
    //     } else {
    //         System.out.println(node.value);
    //     }
    //     display(node.left, level + 1);
    // }

    void print() {
        System.out.println("┌─────────── ");
        System.out.println("│ Tree Start ");
        System.out.println("│   ");
        print(this.root, "", false);
    }

    private void print(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value + " (H: " + node.height + ")");
            print(node.left, prefix + (isLeft ? "│   " : "    "), true);
            print(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

}