import java.util.*;

/**
 *  Find the height difference between two nodes in a binary tree.
 */
public class NodeHeightDiffInBinaryTree {
    
    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return this.val;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || (this.getClass() != other.getClass())) {
                return false;
            }

            return this.val == ((Node) other).val;
        }
        
        public String toString() {
            return String.valueOf(val);
        }
    }

    private static Node createTree() {
        /*
         *          1
         *          2              3
         *          5      4       7        6
         *          8     13   9   10 12     11  14
         *          15     16          17   18 19
         */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        Node n16 = new Node(16);
        Node n17 = new Node(17);
        Node n18 = new Node(18);
        Node n19 = new Node(19);
 
        n1.left = n2;
        n1.right = n3;
        n2.left = n5;
        n2.right = n4;
        n3.left = n7;
        n3.right = n6;
        n5.left = n8;
        n4.right = n9;
        n4.left = n13;
        n7.left = n10;
        n7.right = n12;
        n6.left = n11;
        n6.right = n14;
        n13.left = n15;
        n9.right = n16;
        n11.left = n17;
        n14.left = n18;
        n14.right = n19;
 
        return n1;
    }    

    /**
     * Note: Could short circuit once nodes are found - instead of pre-populating
     * But if querying the difference is a common operation, pre-population is optimal
     */
    public static void main(String[] args) {
        Node root = createTree();
        Map<Node, Integer> nodeHeightMap = new HashMap<>();
        nodeHeightMap.put(root, 0);
        // queue up the nodes
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            int currentHeight = nodeHeightMap.get(current);
            
            if (current.left != null) {
                nodeHeightMap.put(current.left, currentHeight+1);
                queue.add(current.left);
            }

            if (current.right != null) {
                nodeHeightMap.put(current.right, currentHeight+1);
                queue.add(current.right);
            }
        }

        // 3
        assert(diff(nodeHeightMap, 2, 17) == 3);
        assert(diff(nodeHeightMap, 1, 6) == 2);
        assert(diff(nodeHeightMap, 12, 15) == 1);
        assert(diff(nodeHeightMap, 5, 7) == 0);
        assert(diff(nodeHeightMap, 5, 100) == -1);
    }

    private static int diff(Map<Node, Integer> map, int x, int y) { 
        Node X = new Node(x);
        Node Y = new Node(y);
        if (!(map.containsKey(X) && map.containsKey(Y))) {
            return -1;
        }
        
        return Math.abs(map.get(X) - map.get(Y));
    }
}
