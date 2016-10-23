import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {

    Deque<T> eStack = new ArrayDeque<>();
    Deque<T> dStack = new ArrayDeque<>();
                
    public void enqueue(T elem) {
        eStack.push(elem);
    }

    public T dequeue() {
        if (dStack.isEmpty()) {
            transfer();
        }
        
        if (!dStack.isEmpty()) {
            return dStack.pop();
        } else {
            return null; //TODO: BAD - refactor
        }
    }
    
    public T peek() {
        if (dStack.isEmpty()) {
            transfer();
        }
        
        return dStack.peek();        
    }

    private void transfer() {
        while (!eStack.isEmpty()) {
            dStack.push(eStack.pop());
        }
    }       
}
