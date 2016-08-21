import java.util.*;

/**
 * Sort a int array to illustrate heap sort/order
 */
public class HeapSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        PQ pq = new PQ(N);
        int[] inputElems = new int[N];
        for (int i = 0; i < N; i++) {
            int elem = in.nextInt();
            inputElems[i] = elem;
            pq.add(elem);
        }

        heapSort(inputElems);
        int[] pqSorted = pq.sort();
        assert(isSorted(pqSorted));
        assert(isSorted(inputElems));
        assert(Arrays.equals(pqSorted, inputElems));
    }

    /**
     * Return true if array is sorted
     */
    public static boolean isSorted(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] < arr[i-1])
                return false;
        }
        
        return true;
    }
    
    /**
     * Use a [MAX] priority queue from the collections api to maintain heap order
     * Remove the head one-by-one
     */
    public static void sortUsingPQ(int[] elems) {
        // use a minPQ
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2-e1);
        for (int elem : elems) {
            pq.add(elem);
        }

        for (int i = elems.length-1; i >= 0; i--) {
            elems[i] = pq.remove();
        }
    } 

    /**
     * Implement the 'sink' routine to maintain heap order
     */
    public static void heapSort(int[] elems) {
        int N = elems.length;
        for (int i = N/2; i >= 0; i--) {
            Utils.sink(elems, i, N);
        }

        while (N > 0) {
            Utils.exch(elems, 0, --N);
            Utils.sink(elems, 0, N);
        }
    }

}

// Static method used by both PQ and regular heap sort
class Utils {

    /**
     * Max heap invariant 
     */
    public static void sink(int[] pq, int k, int N) {
        while (2*k <= N-1) {
            int j = 2*k;
            if (j < N-1 && less(pq, j, j+1)) j++;
            if (!less(pq, k, j))  break;
            exch(pq, k, j);
            k = j;
        }
    }

    public static void swim(int[] pq, int k, int N) {
        // k/2, k
        while (k > 0 && less(pq, k/2, k)) {
            exch(pq, k, k/2);
            k = k/2;
        }
    }

    public static boolean less(int[] pq, int i , int j) {
        return pq[i] < pq[j];
    }

    public static void exch(int[] pq, int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    
    
}

// A highly-stripped down, bare-bones Priority Queue implementation
class PQ {

    int[] pq;
    int currentSize;
    
    public PQ(int size) {
        pq = new int[size];
        currentSize = 0;
    }
    
    /**
     * Add an element
     */
    public void add(int elem) {
        // add at the currentSize position and increment
        pq[currentSize] = elem;
        Utils.swim(pq, currentSize, currentSize);
        currentSize++;
    }

    /**
     * Return a sorted copy of the array backing the PQ
     */
    public int[] sort() {
        int N = currentSize;
        int[] clone = pq.clone();
        while (N > 0) {
            Utils.exch(clone, 0, --N);
            Utils.sink(clone, 0, N);
        }

        return clone;
    }
    
}
