import java.util.*;

/**
 * A simple backtracking approach to sort an array(list)
 * Source: https://thetokenizer.com/2013/01/13/practicing-backtracking/
 * Very inefficient. Would never do it for an actual use-case. 
 * *Only* for illustrative purposes.
 */
public class BackTrackingSort {

    public static int counter = 0;

    public static boolean sortBacktracking(List<Integer> inputList,
                                           List<Integer> outputList,
                                           int level) {
        // Trace
        counter++;
        System.out.println(counter + "# Level " + level + ": "
                           + inputList + " " + outputList);

        // Reject - this path doesn'tt lead to any solution
        if (outputList.size() > 1 &&
            (outputList.get(outputList.size() - 2) > outputList.get(outputList.size() - 1)))
            return false;

        // Accept - We found a solution
        if (inputList.size() == 0) {
            System.out.println("Solution: " + outputList);
            return true;
        }

        // Step - go over all the possible options in the input
        for (Integer elem : inputList) {
            List<Integer> inputClone = (ArrayList<Integer>)((ArrayList<Integer>)inputList).clone();
            inputClone.remove(elem);
            List<Integer> outputClone = (ArrayList<Integer>)((ArrayList<Integer>)outputList).clone();
            outputClone.add(elem);
            boolean test = sortBacktracking(inputClone, outputClone, level+1);
            if (test) return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(3);
        inputList.add(2);
        inputList.add(1);
        inputList.add(50);
        
        assert(sortBacktracking(inputList, new ArrayList<Integer>(), 0));
    }
    
}
