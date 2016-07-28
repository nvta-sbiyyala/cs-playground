import java.util.*;

/**
 * http://www.geeksforgeeks.org/618/
 */
class TreeTraversal {
    public static class Node {
        Node left;
        Node right;
        int val;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void printTreeInOrder(Node root) {
        inorderTraversal(root);
        System.out.println();
    }
    
    public static void printTreePostOrder(Node head) {
        postorderTraversal(head);
        System.out.println();
    }

    private static void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");
    }
    
    private static void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    /**
     * Non-recursive 
     */
    public static void preorderTraversal(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            System.out.print(tmpNode.val + " ");
            if (tmpNode.right != null)
                stack.push(tmpNode.right);
            if (tmpNode.left != null)
                stack.push(tmpNode.left);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numElems = in.nextInt();
        // root of the tree
        Node root;
        int rootVal = in.nextInt();
        // set the children later
        root = new Node(rootVal);
        int tmpNumElems = numElems;
        numElems--;
        
        Deque<Node> queue = new ArrayDeque<>();         
        queue.add(root);

        while (numElems > 0) {
            Node tmpNode = queue.remove();
            if (tmpNode == null) {
                break;
            }
            
            Node tmpLeftNode = new Node(in.nextInt());
            Node tmpRightNode = new Node(in.nextInt());

            tmpNode.left = tmpLeftNode;
            tmpNode.right = tmpRightNode;
            queue.add(tmpLeftNode);
            queue.add(tmpRightNode);

            numElems -= 2;
        }

        System.out.println("Pre order:");
        preorderTraversal(root);
        System.out.println("In order:");
        printTreeInOrder(root);
        System.out.println("Post order:");
        printTreePostOrder(root);
    }
}
