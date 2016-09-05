/**
 * A collection of linked list related problems
 */
public class LinkedListProblems {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        
        LinkedListProblems driver = new LinkedListProblems();
        Node head = new Node(1);
        Node tmpHead = head;
        for (int i = 2; i <= 20; i++) {
            Node newNode = new Node(i);
            tmpHead.next = newNode;
            tmpHead = tmpHead.next;
        }

        tmpHead.next = new Node(19);
        tmpHead = tmpHead.next;
        tmpHead.next = new Node(19);

        //printLinkedList(driver.iterativeReversal(head));
        System.out.println("==========================");
        printLinkedList(head);
        System.out.println("==========================");
        printLinkedList(removeAll(head, 19));
    }


    /**
     * Remove all occurrences of val and return head
     */
    public static Node removeAll(Node head, int value) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (curr.value == value) {
                if (curr == head) {
                    head = head.next;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node tmpNode = head;
        while (tmpNode != null) {
            System.out.println(tmpNode.value);
            tmpNode = tmpNode.next;
        }
    }

    public Node iterativeReversal(Node head) {
        Node current = head;
        Node prev = null;
        
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }

}
