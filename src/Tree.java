// A Soozay
// 8/12/24
// Binary Tree Search
// NOTE: contains two classes, TreeNode and Tree
//-----------------------------------------------------------------------------------------------------------------------------------
// TreeNode
// creates a TreeNode object top use in our binary trees
class TreeNode<E extends Comparable<E>> {
   TreeNode<E> leftNode;
   E data;
   TreeNode<E> rightNode;

   // method: TreeNode (no return type)
   // purpose: constructs the TreeNode object 
   // parameters:   (1) nodeData (E) data for tree node
   public TreeNode(E nodeData) {
       data = nodeData;
       leftNode = rightNode = null; 
   }

   // method: insert (void)
   // purpose: creates a new TreeNode and inserts the data
   // parameters:   (1) insertValue (E) data for tree node
   public void insert(E insertValue) {
       if (insertValue.compareTo(data) < 0) {
           if (leftNode == null) {
               leftNode = new TreeNode<>(insertValue);
           } else { 
               leftNode.insert(insertValue);
           }
       }
c
       else if (insertValue.compareTo(data) > 0) {
        
           if (rightNode == null) {
               rightNode = new TreeNode<>(insertValue);
           } else { 
               rightNode.insert(insertValue);
           }
       }
   }
}


// Tree
// create and provides maniplulators for a binary tree
public class Tree<E extends Comparable<E>> {
   private TreeNode<E> root;

   // method: Tree (no return type)
   // purpose: constructs the tree
   // parameters: none
   public Tree() {
       root = null;
   }


   // method: insertNode (void)
   // purpose: inserts a TreeNode into the tree
   // parameters:   (1) insertValue (E) data for the TreeNode
   public void insertNode(E insertValue) {
       if (root == null) {
           root = new TreeNode<>(insertValue); 
       } else {
           root.insert(insertValue); 
       }
   }


   // method: preorderTraversal (void)
   // purpose: traverses the binary tree in preorder
   // parameters: none
   public void preorderTraversal() {
       preorderHelper(root);
   }


   // method: preOrderHelper (void)
   // purpose: prints out the data in the preorder order
   // parameters:   (1) node (TreeNode<E>) the current node in the tree
   private void preorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       System.out.printf("%s ", node.data); 
       preorderHelper(node.leftNode); 
       preorderHelper(node.rightNode); 
   }


   // method: inorderTraversal (void)
   // purpose: traverses the binary tree in inorder
   // parameters: none
   public void inorderTraversal() {
       inorderHelper(root);
   }


   // method: inorderHelper (void)
   // purpose: prints out the data in the inorder order
   // parameters:   (1) node (TreeNode<E>) the current node in the tree
   private void inorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       inorderHelper(node.leftNode); 
       System.out.printf("%s ", node.data); 
       inorderHelper(node.rightNode); 
   }


   // method: postorderTraversal (void)
   // purpose: traverses the binary tree in postorder
   // parameters: none
   public void postorderTraversal() {
       postorderHelper(root);
   }


   // method: postOrderHelper (void)
   // purpose: prints out the data in the postorder order
   // parameters:   (1) node (TreeNode<E>) the current node in the tree
   private void postorderHelper(TreeNode<E> node) {
       if (node == null) {
           return;
       }

       postorderHelper(node.leftNode); 
       postorderHelper(node.rightNode); 
       System.out.printf("%s ", node.data); 
   }


   // method: outputTree (void)
   // purpose: prints out the tree in hoirzontal layout, with the top of the tree on the left, and end of the tree on the right
   // parameters: none
   public void outputTree() {
       int start = 0;
       int totalSpaces = 5;
       outputTreeHelper(root, start, totalSpaces);
   }


   // outputTreeHelper (void)
   // pupose: helper method for printing the tree, also establishes the spaces between the levels of the tree
   // parameters:   (1) node (Tree<E>) current node in the tree
   //               (2) start (int) starting spot for the current node
   //               (3) totalSpaces (int) total spaces between the levels
   private void outputTreeHelper(TreeNode<E> node, int start, int totalSpaces) {
       if (node == null) {
           return;
       }

       
       start += totalSpaces;

       outputTreeHelper(node.rightNode, start, totalSpaces);

       System.out.println();
       printSpaces(start - totalSpaces);
       System.out.println(node.data);

       outputTreeHelper(node.leftNode, start, totalSpaces);
   }


   // method: printSpaces (void)
   // purpose: prints the spaces between the nodes
   // parameters:   (1) count (int) the number of spaces between the nodes
   private void printSpaces(int count) {
       for (int i = 0; i < count; i++) {
           System.out.print(" ");
       }
   }
}
