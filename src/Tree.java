
class TreeNode<E extends Comparable<E>> {
   TreeNode<E> leftNode;
   E data;
   TreeNode<E> rightNode;

   public TreeNode(E nodeData) {
       data = nodeData;
       leftNode = rightNode = null; 
   }

   public void insert(E insertValue) {
       if (insertValue.compareTo(data) < 0) {
           if (leftNode == null) {
               leftNode = new TreeNode<>(insertValue);
           } else { 
               leftNode.insert(insertValue);
           }
       }

       else if (insertValue.compareTo(data) > 0) {
        
           if (rightNode == null) {
               rightNode = new TreeNode<>(insertValue);
           } else { 
               rightNode.insert(insertValue);
           }
       }
   }
}


public class Tree<E extends Comparable<E>> {
   private TreeNode<E> root;

   public Tree() {
       root = null;
   }

   public void insertNode(E insertValue) {
       if (root == null) {
           root = new TreeNode<>(insertValue); 
       } else {
           root.insert(insertValue); 
       }
   }

   
   public void preorderTraversal() {
       preorderHelper(root);
   }

   
   private void preorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       System.out.printf("%s ", node.data); 
       preorderHelper(node.leftNode); 
       preorderHelper(node.rightNode); 
   }

   
   public void inorderTraversal() {
       inorderHelper(root);
   }

 
   private void inorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       inorderHelper(node.leftNode); 
       System.out.printf("%s ", node.data); 
       inorderHelper(node.rightNode); 
   }
   
   public void postorderTraversal() {
       postorderHelper(root);
   }

   
   private void postorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       postorderHelper(node.leftNode); 
       postorderHelper(node.rightNode); 
       System.out.printf("%s ", node.data); 
   }

   
   public void outputTree() {
       int initialSpace = 0;
       int levelGap = 5;
       outputTreeHelper(root, initialSpace, levelGap);
   }

   
   private void outputTreeHelper(TreeNode<E> node, int space, int levelGap) {
       if (node == null) {
           return;
       }

       
       space += levelGap;

       outputTreeHelper(node.rightNode, space, levelGap);

       System.out.println();
       printSpaces(space - levelGap);
       System.out.println(node.data);

       outputTreeHelper(node.leftNode, space, levelGap);
   }

   private void printSpaces(int count) {
       for (int i = 0; i < count; i++) {
           System.out.print(" ");
       }
   }
}
