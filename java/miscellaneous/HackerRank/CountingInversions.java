public class CountingInversions {

    public static void main(String[] args) {
        assert(countInversions(new Integer[] {2, 1, 3, 1, 2}) == 4);
        assert(countInversions(new Integer[] {1, 2, 4}) == 0);
        assert(countInversions(new Integer[] {2, 4, 1}) == 2);
    }

    private static long countInversions(Integer[] arr) {
        Integer[] aux = new Integer[arr.length];
        return countInversionsWhileSorting(arr, aux, 0, arr.length-1);
    }

    private static long countInversionsWhileSorting(Integer[] arr, Integer[] aux, int lo, int hi) {
        
        if (hi <= lo) return 0;

        long count = 0;
        int mid = (lo + hi)/2;
        count += countInversionsWhileSorting(arr, aux, lo, mid);
        count += countInversionsWhileSorting(arr, aux, mid+1, hi);
        count += countInversionsWhileMerging(arr, aux, lo, hi);
        
        return count;
    }

    private static long countInversionsWhileMerging(Integer[] arr, Integer[] aux, int lo, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k]; 
        }
                
        int mid = (lo + hi)/2;
        int i = lo;
        int j = mid+1;
                
        long count = 0;
        for (int idx = lo; idx <= hi; idx++) {
            if (i > mid) arr[idx] = aux[j++];
            else if (j > hi) arr[idx] = aux[i++];
            else if (aux[j] < aux[i]) {
                count += mid + 1 - i;
                arr[idx] = aux[j++];
            } else arr[idx] = aux[i++];
        }

        return count;
    }
}
