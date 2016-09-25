import java.util.*;

/**
 * http://www.geeksforgeeks.org/618/
 */
public class TreeTraversal {
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

    public static void printTreePreOrder(Node root) {
        preorderTraversal(root);
        System.out.println();
    }

    public static void printTreePreOrderIterative(Node root) {
        preorderTraversalIterative(root);
        System.out.println();
    }

    public static void printTreeInOrder(Node root) {
        inorderTraversal(root);
        System.out.println();
    }

    public static void printTreeInOrderIterative(Node root) {
        inorderTraversalIterative(root);
        System.out.println();
    }
    
    public static void printTreePostOrder(Node head) {
        postorderTraversal(head);
        System.out.println();
    }

    public static void printTreePostOrderIterativeTwoStacks(Node root) {
        postorderTraversalIterativeTwoStacks(root);
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

    /**
     * Iterative post order traversal
     */
    private static void postorderTraversalIterativeTwoStacks(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node poppedOutNode = stack1.pop();
            stack2.push(poppedOutNode);
            if (poppedOutNode.left != null)
                stack1.push(poppedOutNode.left);
            if (poppedOutNode.right != null)
                stack1.push(poppedOutNode.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(" " + stack2.pop().val);
        }
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
     * Iterative in order traversal
     */
    private static void inorderTraversalIterative(Node root) {
        if (root == null)
            return;

        Deque<Node> stack = new ArrayDeque<Node>();
        Node node = root;
        pushLeftNodesOntoStack(stack, node);
        while (!stack.isEmpty()) {
            Node poppedOutNode = stack.pop();
            System.out.print(" " + poppedOutNode.val);
            if (poppedOutNode.right != null) {
                node = poppedOutNode.right;
                pushLeftNodesOntoStack(stack, node);
            }
        }
    }

    /**
     * Side Effects!
     */
    private static void pushLeftNodesOntoStack(Deque<Node> stack, Node node) {
	
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    
    public static void preorderTraversalIterative(Node root) {
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

        System.out.println("Pre order traversal:");
        printTreePreOrder(root);

        System.out.println("Pre order traversal iterative:");
        printTreePreOrderIterative(root);
        
       System.out.println("In order traversal:");
        printTreeInOrder(root);

        System.out.println("In order traversal iterative:");
        printTreeInOrderIterative(root);
        
        System.out.println("Post order traversal:");
        printTreePostOrder(root);

        System.out.println("Post order traversal using 2 stacks:");
        printTreePostOrderIterativeTwoStacks(root);
    }
}
