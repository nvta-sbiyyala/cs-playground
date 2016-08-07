import java.util.*;

public class SumOfPairs {
    public static void main(String[] args) {
        List<int[]> result = findPairs(new int[]{3, 7, 2, 5, 6, 4}, 10);
        assert(result.size() == 2);

        result = findPairs(new int[]{3, 7, 2, 5, 6, 4}, 9);
        assert(result.size() == 3);
    }

    private static List<int[]> findPairs(int[] inputArray, int K) {
        List<int[]> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int key : inputArray) {
            Integer val = map.get(key);
            if (val == null) {
                val = 1;
            } else {
                val += 1;
            }
            map.put(key, val);
        }

        Set<Integer> keySet = new HashSet<>(map.keySet());

        keySet.forEach(elem -> {
                int candidateValue = K - elem;
                // decrement the count of this elem in the map
                map.put(elem, map.get(elem)-1);
                Integer candidateCount = map.get(candidateValue);
                if (candidateCount != null && candidateCount > 0) {
                    result.add(new int[]{elem, candidateValue});
                    map.put(candidateValue, --candidateCount);
                }
            });

        return result;
    }
}
