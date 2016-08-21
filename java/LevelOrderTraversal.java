import java.util.*;

/**
 * pipe separate the levels of a binary tree
 * Eg: 
 * 
 *        7
 *       /  \
 *     4      8
 *    / 
 *   3
 *  /
 * 1
 * Output: 7 | 4 8 | 3 | 1
 */
public class LevelOrderTraversal {
    static class Node {
        Node left;
        Node right;
        int val;
        int level = 0;
        
        public Node (int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        // create a test
        // root
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

        System.out.println(performLevelOrderTraversal(root));
    }

    private static String performLevelOrderTraversal(Node root) {
        StringBuilder sb = new StringBuilder();
        Deque<Node> Q = new ArrayDeque<>();
        Q.add(root);
        // Do a BST, assign levels for each node
        while (!Q.isEmpty()) {
            Node node = Q.remove();                        
            if (node.left != null) {
                node.left.level = node.level + 1;
                Q.add(node.left);
            }
            
            if (node.right != null) {
                node.right.level = node.level + 1;
                Q.add(node.right);
            }
        }

        // Create a map between level number and corresponding list of node values
        Map<Integer, List<Integer>> levelMapping = new HashMap<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            Node node = Q.remove();
            if (node.left != null)
                Q.add(node.left);
            if (node.right != null)
                Q.add(node.right);
            List<Integer> values = levelMapping.get(node.level);
            if (values == null) {
                values = new ArrayList<Integer>();
                levelMapping.put(node.level, values);
            }

            values.add(node.val);
        }

        levelMapping.forEach((k, v) -> {
                v.forEach(elem -> sb.append(elem + " "));
                sb.append("| ");
            });
        
        return sb.toString();
    }
}
