import java.security.SecureRandom;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        for (int i = 1; i <= 10; i++) {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

        System.out.printf("%n%nHorizontal Tree Display%n");


        Tree<Integer> tree2 = new Tree<>();
        tree2.insertNode(97);
        tree2.insertNode(39);
        tree2.insertNode(72);
        tree2.insertNode(83);
        tree2.insertNode(8);
        tree2.insertNode(58);
        tree2.insertNode(17);
        tree2.insertNode(5);
        tree2.insertNode(71);
        tree2.insertNode(30);
        tree2.outputTree();
    }

    
}
