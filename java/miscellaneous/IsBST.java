// Write a method that takes the root of a tree as input and check if the tree is a Binary Search Tree (BST).
public class IsBST {

    static int prev = Integer.MIN_VALUE;
    
    static class Node {
        Node left;
        Node right;
        int val;
        
        public Node (int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(4);
        Node left = new Node(2);
        Node right = new Node(6);
        root.left = left;
        root.right = right;
        left.left = new Node(1);
        left.right = new Node(3);
        right.left = new Node(5);
        right.right = new Node(7);

        assert(isBST(root));
    }

    /**
     * In order traversal yields sorted array for a BST
     */
    private static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }

        if (!isBST(node.left))
            return false;

        if (node.val < prev)
            return false;
        
        prev = node.val;

        return isBST(node.right);
    }
    
}
