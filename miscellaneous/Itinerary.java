import java.util.*;
import java.util.stream.Collectors;

/**
 * [JFK, LXA, SNA, RKJ, LXA, SNA] 
 * each 2 group define a route. so, 
 * 
 * JFK -> LXA 
 * SNA -> RKJ 
 * LXA -> SNA 
 * * 
 * Find the path from departure to destination. note: departure and destination are not 
 * known. 
 */
public class Itinerary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.next().split(",");
        if (input.length%2 != 0) {
            System.err.println("Invalid input");
            System.exit(-1);
        }
        
        Map<String, String> mapping = new HashMap<String, String>(input.length/2);
        for (int i = 0; i < input.length-1; i+=2) {
            mapping.put(input[i], input[i+1]);
        }

        String current = getStart(mapping);
        System.out.print(current);
        while (mapping.containsKey(current)) {
            String tmpValue = mapping.get(current);
            System.out.print("->" + tmpValue);
            current = tmpValue;
        }

        System.out.println();
    }

    private static String getStart(Map<String, String> mapping) {
        Set<String> startSet = new HashSet<>(mapping.keySet());
        startSet.removeAll(mapping.values()
                .stream()
                .collect(Collectors.toSet()));
        return startSet.iterator().next();
   }
}
