/**
 * Implement a stack having findMiddle operation as well, which returns middle element of stack on O(1) time.
 */
public class StackWithMiddle {
    
    public static void main(String[] args) {
	Stack stack = new Stack();
	stack.push(19);
	printStack(stack.top);
	assert(stack.size() == 1);
	assert(stack.middle() == 19);

	assert(stack.peek() == 19);

	stack.push(1);
	printStack(stack.top);
	assert(stack.size() == 2);
	assert(stack.middle() == 19);

	stack.push(18);
	printStack(stack.top);
	assert(stack.middle() == 1);
	
	stack.push(118);
	printStack(stack.top);
	assert(stack.middle() == 1);
    }

    private static void printStack(Stack.Node head) {
	System.out.println("===============");
	Stack.Node tmp = head;
	while (tmp != null) {
	    System.out.print(tmp.elem + " ");
	    tmp = tmp.right;
	}
	System.out.println("\n===============");
    }
    
}

/**
 * LinkedList-backed implementation of a stack
 * int stack for simplicity
 * API: 1. push() 2. pop() 3. peek() 4. middle()
 */
class Stack {

    static class Node {
	int elem;
	Node left;
	Node right;

	public Node(int elem) {
	    this.elem = elem;
	}

	public String toString() {
	    return String.valueOf(elem);
	}
    }

    Node top;
    Node middle;
    int size;
    
    public void push(int newElem) {
	Node newNode = new Node(newElem);
	newNode.right = top;
	if (top != null)
	    top.left = newNode;
	top = newNode;
	size += 1;

	if (size % 2 == 1) {
	    if (size == 1) {
		middle = top;
	    } else {
		middle = middle.left;
	    }
	}
    }

    public int pop() {
	if (size == 0)
	    return -1;
	
	Node poppedNode = top;
	top = top.right;
	size -= 1;
	
	return poppedNode.elem;
    }

    public int middle() {
	if (size == 0)
	    return -1;
	
	return middle.elem;
    }

    public int peek() {
	if (size == 0)
	    return -1;
	
	return top.elem;
    }

    public int size() {
	return size;
    }
    
}
