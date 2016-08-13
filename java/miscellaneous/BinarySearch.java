import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A BinarySearch loosely based on Collections.binarySearch api
 */
public class BinarySearch {

    /**
     * LUB - Least upper bound represents greatest value smaller than an absent key
     * GLB - Greatest lower bound represents smallest value greater than an absent key
     */
    private enum Index {
        LUB,
        GLB
    }
    
    public static void main(String[] args) {

        List<Integer> li = new ArrayList<>();
        li.add(4);
        li.add(1);
        li.add(2);
        li.add(5);
        li.add(6);
        Collections.sort(li);
        assert(binarySearch(li, 3, Index.LUB) == -1);
        assert(binarySearch(li, 3, Index.GLB) == -2);

        List<String> strList = new ArrayList<>();
        strList.add("Adrian");
        strList.add("Bob");
        strList.add("Zorrow");
        strList.add("Victor");
        Collections.sort(strList);
        assert(binarySearch(strList, "Albert", Index.LUB) == 0);
        assert(binarySearch(strList, "Albert", Index.GLB) == -1);
    }

    /**
     * If found, return index of key occurence
     * Else return greatest smaller number than key or 
     * smallest larger number than key, depending of idx enum.
     * Both these indices would be candidates to insert this key
     */
    private static <T> int binarySearch(List<? extends Comparable<? super T>> list,
                                        T key,
                                        Index idx) {
        int start = 0;
        int end = list.size()-1;
        int largestLeftIdx = 0;
        int smallestRightIdx = 0;
        int resultIdx = 0;
        
        int candidateLocation = 0;

        while (start <= end) {
            int mid = (start+end)/2;
            if (list.get(mid).compareTo(key) < 0) {
                largestLeftIdx = mid;
                start = mid+1;
            } else if (list.get(mid).compareTo(key) > 0) {
                smallestRightIdx = mid;
                end = mid-1;
            } else {
                return mid;
            }
        }

        switch(idx) {
        case LUB:
            resultIdx = largestLeftIdx == 0 ? 0 : -(largestLeftIdx);
            break;
        case GLB:
            resultIdx = smallestRightIdx == 0 ? -(list.size()) : -(smallestRightIdx);
            break;
        default:
            break;
        }
        
        return resultIdx;
    }
}
