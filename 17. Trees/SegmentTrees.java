
public class SegmentTrees {

    private static class Node {
        int data, start, end;
        Node left, right;

        Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    SegmentTrees(int[] arr) {
        this.root = construct(arr, 0, arr.length-1);
    }

    private Node construct(int[] arr, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {    
            node.data = arr[start];
            return node;
        }

        int mid = (start + end) / 2;

        node.left = this.construct(arr, start, mid);
        node.right = this.construct(arr, mid+1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    
    int query(int query_start, int query_end) {
        return this.query(this.root, query_start, query_end);
    }
    
    private int query(Node node, int query_start, int query_end) {

        // if exists then return num
        if (node.start >= query_start && node.end <= query_end) {
            return node.data;
        }

        // if not exists then return 0
        else if (node.start > query_end && node.end < query_start) {
            return 0;
        }
        
        // if in between then check the right and left node
        else {
            int left = node.left != null ? this.query(node.left, query_start, query_end) : 0;
            int right = node.right != null ? this.query(node.right, query_start, query_end) : 0;
            return left + right;
        }
    }

    void update(int index, int value) {
        this.root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.start && index <= node.end) {
            if (index == node.start && index == node.end) {
                node.data = value;
                return node.data;
            } else {
                int left = node.left != null ? update(node.left, index, value) : 0;
                int right = node.right != null ? update(node.right, index, value) : 0;
                
                node.data = left + right;
                return node.data;
            }
        }
        return node.data;
    }

    // void print() {
    //     print(this.root);
    // }

    // private void print(Node node) {
    //     String str = "";

    //     if (node.left != null) {
    //         str = str + "Interval = [" + node.left.start + " - " + node.left.end + "] and data: " + node.left.data + "\n";
    //     } else {
    //        str = str + "No left child\n"; 
    //     }
    //     str = str + "Interval = [" + node.start + " - " + node.end + "] and data: " + node.data + "\n";

    //     if (node.right != null) {
    //         str = str + "Interval = [" + node.right.start + " - " + node.right.end + "] and data: " + node.right.data + "\n";
    //     } else {
    //        str = str + "No left child\n"; 
    //     }

    //     System.out.println(str);

    //     if (node.left != null) print(node.left);
    //     if (node.right != null) print(node.right);
    // }
    
    private void print(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") +
                    "Interval = [" + node.start + " - " + node.end + "], Data: " + node.data);
    
            print(node.left, prefix + (isLeft ? "│   " : "    "), true);
            print(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
    
    void print() {
        System.out.println("┌─────────── ");
        System.out.println("│ Tree Start ");
        System.out.println("│   ");
        print(this.root, "", false);
    }
}
