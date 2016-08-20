import java.util.*;

/**
 * Sort a int array to illustrate heap sort/order
 */
public class HeapSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] inputElems1 = new int[N];
        int[] inputElems2 = new int[N];
        for (int i = 0; i < N; i++) {
            int elem = in.nextInt();
            inputElems1[i] = elem;
            inputElems2[i] = elem;
        }

        sort(inputElems1);
        heapSort(inputElems2);
        assert(isSorted(inputElems1));
        assert(isSorted(inputElems2));
        assert(Arrays.equals(inputElems1, inputElems2));
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
     * Use a [MIN] priority queue to maintain heap order
     * Remove the head one-by-one
     */
    public static void sort(int[] elems) {
        // use a minPQ
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (int elem : elems) {
            Q.add(elem);
        }

        for (int i = 0; i < elems.length; i++) {
            elems[i] = Q.remove();
        }
    }

    /**
     * Implement the 'sink' routine to maintain heap order
     */
    public static void heapSort(int[] elems) {
        int N = elems.length;
        for (int i = N/2; i >= 0; i--) {
            sink(elems, i, N);
        }

        while (N > 0) {
            exch(elems, 0, --N);
            sink(elems, 0, N);
        }
    }

    /**
     * Max heap invariant 
     */
    private static void sink(int[] pq, int k, int N) {
        while (2*k <= N-1) {
            int j = 2*k;
            if (j < N-1 && less(pq, j, j+1)) j++;
            if (!less(pq, k, j))  break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(int[] pq, int i , int j) {
        return pq[i] < pq[j];
    }

    private static void exch(int[] pq, int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

}
