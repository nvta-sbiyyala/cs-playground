import java.util.*;
import java.util.stream.*;

/**
 * Given pairs dependencies
 * A D
 * A F
 * B A
 * B E
 * E C
 * G E
 * G C
 * H G
 */
public class OperatorDependencies {
    
    public static void main(String[] args) {
        Map<String, Set<String>> mapping = generateOpsToDepsMap();
        List<String> path = new ArrayList<String>();

        Set<String> keySet = mapping.keySet();
        Set<String> valSet = mapping
            .values()
            .stream()
            .flatMap(c -> c.stream())
            .collect(Collectors.toSet());
        
        path.addAll(valSet
                    .stream()
                    .filter(x -> !keySet.contains(x))
                    .collect(Collectors.toList()));

        computeValidPath(mapping, path);
        assert(isValidPath(generateOpsToDepsMap(), path));
        assert(isValidPath(generateOpsToDepsMap(), Arrays.asList(new String[]{"D", "C", "F", "A", "E", "B", "G", "H"})));
        assert(isValidPath(generateOpsToDepsMap(), Arrays.asList(new String[]{"F", "D", "C", "A", "E", "B", "G", "H"})));
        assert(!isValidPath(generateOpsToDepsMap(), Arrays.asList(new String[]{"A", "D", "C", "F", "E", "B", "G", "H"})));
    }

    private static void computeValidPath(Map<String, Set<String>> mapping, List<String> path) {
        if (mapping.isEmpty()) {
            return;
        }

        mapping.forEach((key, val) -> {
                for (Iterator<String> i = val.iterator(); i.hasNext(); ) {
                    String tmp = i.next();
                    if (path.contains(tmp)) {
                        i.remove();
                    }
                }
            });

        for (Iterator<Map.Entry<String, Set<String>>> it = mapping.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Set<String>> next = it.next();
            if (next.getValue().isEmpty()) {
                path.add(next.getKey());
                it.remove();
            }
        }

        computeValidPath(mapping, path);
    }

    private static Map<String, Set<String>>  generateOpsToDepsMap() {

        Map<String, Set<String>> opToDeps = new HashMap<>();        
        opToDeps.put("A", Stream.of("D", "F").collect(Collectors.toSet()));
        opToDeps.put("B", Stream.of("A", "E").collect(Collectors.toSet()));
        opToDeps.put("E", Stream.of("C").collect(Collectors.toSet()));
        opToDeps.put("G", Stream.of("E", "C").collect(Collectors.toSet()));
        opToDeps.put("H", Stream.of("G").collect(Collectors.toSet()));

        return opToDeps;
    }

    // Not quite functional, still has side-effects
    private static boolean isValidPath(Map<String, Set<String>> mapping, List<String> path) {

        Set<String> pathElems = new HashSet<>(path);
        Set<String> removedElems = new HashSet<>();
        return !path.stream()
            .anyMatch(elem -> {
                    Set<String> depSet = mapping.get(elem);
                    pathElems.remove(elem);
                    removedElems.add(elem);
                    return (depSet != null && !removedElems.containsAll(depSet));
                });

    }
}
