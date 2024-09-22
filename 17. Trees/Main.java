//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // BinaryTree tree = new BinaryTree();
        // tree.insert(sc);
        // tree.print();
        // tree.preOrder();
        // System.out.println();
        // tree.inOrder();
        // System.out.println();
        // tree.postOrder();
        // System.out.println();

        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // BST bst = new BST();
        // bst.insert(15);
        // bst.insert(8);
        // bst.insert(20);
        // bst.insert(3);
        // bst.insert(13);
        // bst.insert(23);
        // bst.print();
        // bst.print();

        // bst.insert(arr);
        // bst.print();
        // bst.print();

        // AVL avl = new AVL();
        // avl.insert(30);
        // avl.insert(20);
        // avl.insert(40);
        // avl.insert(10);
        // avl.insert(25);
        // avl.insert(35);
        // avl.insert(50);
        // System.out.println("Height: "+avl.height());
        // avl.print();
        // System.out.println("Is the tree balanced?"+avl.isBalanced());

        int[] arr = {3,2,3,4,5,35,7,8,8,84};
        SegmentTrees tree = new SegmentTrees(arr);
        tree.print();
        System.out.println(tree.query(3, 6));
    }
}
