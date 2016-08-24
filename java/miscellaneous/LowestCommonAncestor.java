import java.util.*;

/**
 * http://articles.leetcode.com/lowest-common-ancestor-of-a-binary-tree-part-i/
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * Covers two variants: 1. LCA of a BST 2. LCA of a normal BT
 */
public class LowestCommonAncestor {

    static int prev = Integer.MIN_VALUE;
    
    static class Node {
        Node left;
        Node right;
        int val;
        int level = 0;
        
        public Node (int val) {
            this.val = val;
        }

        public boolean equals(Node otherNode) {
            return this.val == otherNode.val;
        }

        public int hashCode() {
            return (new Integer(val)).hashCode();
        }
    }
    
    public static void main(String[] args) {
        testBST();
        testBT();
    }

    static void testBT() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        left.left = new Node(4);
        left.right = new Node(5);
        right.left = new Node(6);
        right.right = new Node(7);
        
        assert(!isBST(root));
        assert(LCA_BT(root, 4, 5).val == 2);
        assert(LCA_BT(root, 4, 6).val == 1);
        assert(LCA_BT(root, 3, 4).val == 1);
        assert(LCA_BT(root, 2, 4).val == 2);
    }

    static void testBT2() {
        Node root = new Node(7);
        Node left = new Node(4);
        Node right = new Node(8);
        root.left = left;
        root.right = right;
        left.left = new Node(3);
        left.right = new Node(15);
        left.left.left = new Node(1);
        left.left.right = new Node(167);
        left.right.right = new Node(16);
        left.right.right.left = new Node(160);
        left.right.right.left.left = new Node(89);

        assert(!isBST(root));
    }

    static void testBST() {
        Node root = new Node(6);
        Node left = new Node(2);
        Node right = new Node(8);
        root.left = left;
        root.right = right;
        left.left = new Node(0);
        left.right = new Node(4);
        left.right.left = new Node(3);
        left.right.right = new Node(5);
        right.left = new Node(7);
        right.right = new Node(9);
        assert(isBST(root));

        assert(LCA_BST(root, 2, 8).val == 6);
        assert(LCA_BST(root, 2, 4).val == 2);

        // can use the LCA_BT as well
        assert(LCA_BST(root, 2, 4).val == LCA_BT(root, 2, 4).val);
        assert(LCA_BST(root, 2, 8).val == LCA_BT(root, 2, 8).val);
    }

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

    /**
     * Worst case: log(n) (thanks to BST order enforced)
     */
    static Node LCA_BST(Node root, int x, int y) {
        if (root == null) return null;
        int max = x >= y ? x : y;
        int min = x <=y ? x : y;
        
        if (root.val > max) {
            return LCA_BST(root.left, x, y);
        } else if (root.val < min) {
            return LCA_BST(root.right, x, y);
        } else {
            return root;
        }
    }

    /**
     * Traverse the tree starting from the root.
     * TODO: NEVER return null, refactor
     * Worst case: n
     */
    static Node LCA_BT(Node root, int x, int y) {
        if (root == null)
            return root;

        if (root.val == x || root.val == y)
            return root;
        
        Node left = LCA_BT(root.left, x, y);
        Node right = LCA_BT(root.right, x, y);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
    
}
