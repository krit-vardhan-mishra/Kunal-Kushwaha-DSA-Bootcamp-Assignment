import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode right, left, next;

    TreeNode (int val) {this.val = val;}
}

class Node {
    int val;
    Node right, left, next;

    Node (int val) {this.val = val;}
}

public class DFS {

    // 643. Diametere Of Binary Tree
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[1];
        height(root, max);
        return max[0];
    }

    private static int height(TreeNode root, int[] max) {
        if (root == null) return 0;

        int left = height(root.left, max);
        int right = height(root.right, max);
        max[0] = Math.max(left + right, max[0]);
        return 1 + left + right;
    }

    // 226. Invert Binary Tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invert(root);
        return root;
    }

    private static void invert(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    // 104. Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    // 108. Convert Sorted Array To Binary Search Tree
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
    
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
    
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
    
        return root;
    }

    // 114. Flatten Binary Tree To Linked List
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // 98. Validate Binary Tree
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if ((lower != null && val <= lower) || (upper != null && val >= upper))return false;
        return isValidBST(node.right, val, upper) && isValidBST(node.left, lower, val);
    }
    
    // 236. Lowest Common Ancestor of a Binary Tree 
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return (left != null && right != null) ? root : (left != null) ? left : right;
    }

    // 230. Kth Smallest Element in a BST
    static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
        return smallest(root, k).val;
    }

    private static TreeNode smallest(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode left = smallest(root.left, k);

        if (left != null) return left;
        count++;
        if (count == k) return root;
        return smallest(root.right, k);
    }

    // 105. Construct Binary Tree from Preorder and Inorder Traversal
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int root = preorder[0];
        int index = 0;

        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

        return node;
    }

    // 297. Serialize and Deserialize Binary Tree
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); 
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] arr = data.split(",");
        int[] index = {0};
        return deserialize(arr, index);
    }

    private static TreeNode deserialize(String[] arr, int[] index) {
        if (index[0] >= arr.length || arr[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]++]));
        root.left = deserialize(arr, index);
        root.right = deserialize(arr, index);

        return root;
    }

    // 112. Path Sum
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

    // 129. Sum Root to Leaf Numbers
    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) return sum;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    // 124. Binary Tree Maximum Path Sum
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    private static int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSumHelper(root.left));
        int right = Math.max(0, maxPathSumHelper(root.right));
        max = Math.max(max, left + right + root.val);

        return root.val + Math.max(left, right);
    }

    // Example 1:
    // Check if Array exists as a Path in a Tree from Root to Leaf
    public static boolean pathExists(TreeNode root, int[] arr) {
        return pathExists(root, arr, 0);
    }

    private static boolean pathExists(TreeNode root, int[] arr, int index) {
        if (root == null) return index == arr.length;
        if (index >= arr.length || root.val != arr[index]) return false;
    
        return pathExists(root.left, arr, index+1) || pathExists(root.right, arr, index+1);
    }

    // Example 2:
    // Check is Array exists as a Path in a Tree
    public static boolean pathExistsAnywhere(TreeNode root, int[] arr) {
        return pathExistsAnywhere(root, arr, 0, false);
    }

    private static boolean pathExistsAnywhere(TreeNode root, int[] arr, int index, boolean isFound) {
        if (root == null) return false;
        if (index == arr.length) return true;
        if (isFound && (index >= arr.length || root.val != arr[index])) return false;
        if (root.val == arr[index]) {
            isFound = true;
            index++;
        }
        return pathExistsAnywhere(root.left, arr, index, isFound) || pathExistsAnywhere(root.right, arr, index, isFound);
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
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a4.right = a8;
        a4.left = a7;
        a3.right = a6;
        a3.left = a5;
        a6.right = a9;

        print(a1);
        int[] arr = {4,11};
        System.out.println(pathExistsAnywhere(a1, arr));
    }
}
