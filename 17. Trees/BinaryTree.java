import java.util.Scanner;

public class BinaryTree {

  BinaryTree() {
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public void insert(Scanner scanner) {
    System.out.println("Enter the root Node : ");
    int value = scanner.nextInt();
    root = new Node(value);
    insert(scanner, root);
  }

  private void insert(Scanner scanner, Node parent) {
    System.out.println("Do you want to insert on the left of " + parent.value + " :");
    boolean left = scanner.nextBoolean();
    if (left) {
      System.out.println("Enter the value for left child of " + parent.value + " : ");
      parent.left = new Node(scanner.nextInt());
      insert(scanner, parent.left);
    }

    System.out.println("Do you want to insert on the right of " + parent.value + " : ");
    boolean right = scanner.nextBoolean();
    if (right) {
      System.out.println("Enter the value for right child of " + parent.value + " : ");
      parent.right = new Node(scanner.nextInt());
      insert(scanner, parent.right);
    }
  }

  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if (node == null)
      return;

    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null)
      return;

    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
  }

  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if (node == null)
      return;

    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }

  // public void print() {
  // print(root, 0);
  // }

  // private void print(Node node, int level) {
  // if (node == null) {
  // return;
  // }

  // print(node.right, level + 1);

  // if (level != 0) {
  // for (int i = 0; i < level - 1; i++) {
  // System.out.print("|\t ");
  // }
  // System.out.println("|------->" + node.value + "|");
  // } else {
  // System.out.println(node.value);
  // }
  // print(node.left, level + 1);
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