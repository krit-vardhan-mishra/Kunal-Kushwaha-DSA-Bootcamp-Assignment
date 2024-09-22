import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class TreeNode {
    int val;
    TreeNode left, right, next;

    TreeNode (int val) {this.val = val;}
}

public class BFS {

    // Print Sum
    public static void printSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            sum += root.val;

            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);

            System.out.println(sum);
        }
    }

    // 637. Average of Levels in Binary Tree
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            double average = sum / size;
            res.add(average);
        }

        return res;
    }

    // 103. Binary Tree Zigzag Level Order Traversal
    public static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) temp.add(node.val);
                else temp.add(0, node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(temp);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // 107. Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(0, temp);
        }

        return result;
    }

    // 236. Lowest Common Ancestor of a Binary Tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return (left != null && right != null) ? root : (left != null) ? left : right;
    }

    // 285. Inorder Successor in Binary Search Tree
    public static TreeNode findSuccessor(TreeNode root, TreeNode key) {
        TreeNode ans = null;

        while (root != null) {
            if (root.val > key.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans;
    }


    // 116. Populating Next Right Pointers in Each Node
    public static Node connect(Node root) {
        if (root == null) return null;
        connection(root);
        return root;
    }

    public static void connection(Node root) {
        if (root == null) return;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next.left;

        connect(root.right);
        connect(root.left);
    }

    // 199. Binary Tree Right Side View  O(n) Space Complexity by using List
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode temp = queue.poll();

                if (i == size - 1) result.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        
        return result;
    }
    
    // 199. Binary Tree Right Side View  O(n) Space Complexity by call stack
    public static List<Integer> right(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSide(root, 0, result);  
        return result;  
    }

    // Recursive Function to Right Side View
    private static void rightSide(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (result.size() == level) result.add(node.val);
        rightSide(node.right, level+1, result);
        rightSide(node.right, level+1, result);
    }

    // 993. Cousins in Binary Tree
    public static boolean isCousins(TreeNode root, int x, int y) {
        int[] xInfo = new int[2];
        int[] yInfo = new int[2];

        checkCousins(root, x, y, 0, null, xInfo, yInfo);

        return xInfo[1] == yInfo[1] && xInfo[0] != yInfo[0];  
    }

    public static void checkCousins(TreeNode node, int first, int second, int level, TreeNode parent, int[] firstInfo, int[] secondInfo) {
        if (node == null) return;
        if (node.val == first) {
            firstInfo[0] = parent != null ? parent.val : -1;
            firstInfo[1] = level;
        } else if (node.val == second) {
            secondInfo[0] = parent != null ? parent.val : -1;
            secondInfo[1] = level;
        }

        checkCousins(node.left, first, second, level+1, node, firstInfo, secondInfo);
        checkCousins(node.right, first, second, level+1, node, firstInfo, secondInfo);
    }

    // 101. Symmetric Tree
    public static boolean isSymmetric(TreeNode root) {
        return symmetry(root, root);
    }

    public static boolean symmetry(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        if (x.val != y.val) return false;

        return symmetry(x.left, y.right) && symmetry(x.right, y.left);
    }

    // Print Function
    static void print(TreeNode root) {
        System.out.println("┌─────────── ");
        System.out.println("│ Tree Start ");
        System.out.println("│   ");
        print(root, "", false);
    }

    static void print(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            String s = (node.next != null) ? String.valueOf(node.next.val) : "null";
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val + " Next : " + s);
            print(node.left, prefix + (isLeft ? "│   " : "    "), true);
            print(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);

        a1.right = a3;
        a1.left = a2;
        a2.right = a5;
        a2.left = a4;
        a3.right = a7;
        a3.left = a6;

        System.out.println(isCousins(a1, 5, 7));
        System.out.println(isCousins(a1, 3, 7));
    }
}
