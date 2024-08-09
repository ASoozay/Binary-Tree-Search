// Fig. 21.15: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
//package com.deitel.datastructures;

// class TreeNode definition
// class TreeNode definition
class TreeNode<E extends Comparable<E>> {
   // package access members
   TreeNode<E> leftNode;
   E data; // node value
   TreeNode<E> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(E nodeData) {
       data = nodeData;
       leftNode = rightNode = null; // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(E insertValue) {
       // insert in left subtree
       if (insertValue.compareTo(data) < 0) {
           // insert new TreeNode
           if (leftNode == null) {
               leftNode = new TreeNode<>(insertValue);
           } else { // continue traversing left subtree recursively
               leftNode.insert(insertValue);
           }
       }
       // insert in right subtree
       else if (insertValue.compareTo(data) > 0) {
           // insert new TreeNode
           if (rightNode == null) {
               rightNode = new TreeNode<>(insertValue);
           } else { // continue traversing right subtree recursively
               rightNode.insert(insertValue);
           }
       }
   }
}

// class Tree definition
public class Tree<E extends Comparable<E>> {
   private TreeNode<E> root;

   // constructor initializes an empty Tree of integers
   public Tree() {
       root = null;
   }

   // insert a new node in the binary search tree
   public void insertNode(E insertValue) {
       if (root == null) {
           root = new TreeNode<>(insertValue); // create root node
       } else {
           root.insert(insertValue); // call the insert method
       }
   }

   // begin preorder traversal
   public void preorderTraversal() {
       preorderHelper(root);
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       System.out.printf("%s ", node.data); // output node data
       preorderHelper(node.leftNode); // traverse left subtree
       preorderHelper(node.rightNode); // traverse right subtree
   }

   // begin inorder traversal
   public void inorderTraversal() {
       inorderHelper(root);
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       inorderHelper(node.leftNode); // traverse left subtree
       System.out.printf("%s ", node.data); // output node data
       inorderHelper(node.rightNode); // traverse right subtree
   }

   // begin postorder traversal
   public void postorderTraversal() {
       postorderHelper(root);
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       postorderHelper(node.leftNode); // traverse left subtree
       postorderHelper(node.rightNode); // traverse right subtree
       System.out.printf("%s ", node.data); // output node data
   }

   // Public method to print the tree horizontally
   public void outputTree() {
       int initialSpace = 0;
       int levelGap = 5;
       outputTreeHelper(root, initialSpace, levelGap);
   }

   // Helper method to print the tree
   private void outputTreeHelper(TreeNode<E> node, int space, int levelGap) {
       // Base case
       if (node == null) {
           return;
       }

       // Increase distance between levels
       space += levelGap;

       // Process right child first
       outputTreeHelper(node.rightNode, space, levelGap);

       // Print current node after space count
       System.out.println();
       printSpaces(space - levelGap);
       System.out.println(node.data);

       // Process left child
       outputTreeHelper(node.leftNode, space, levelGap);
   }

   // Helper method to print spaces
   private void printSpaces(int count) {
       for (int i = 0; i < count; i++) {
           System.out.print(" ");
       }
   }
}
