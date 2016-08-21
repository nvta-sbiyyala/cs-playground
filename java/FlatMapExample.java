import java.util.*;
import java.util.stream.*;

/**
 * A simple example of the java 8 FlatMap construct 
 * Ref: http://www.adam-bien.com/roller/abien/entry/java_8_flatmap_example
 */
class FlatMapExample {
    public static void main(String[] args) {
        testFlatMap();
    }

    static void testFlatMap() {
        List<Developer> teams = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("python");
        busy.add("javascript");
        busy.add("c");
        busy.add("cpp");

        teams.add(polyglot);
        teams.add(busy);

        List<String> teamLanguages = teams
            .stream()
            .map(elem -> elem.getLanguages())
            .flatMap(elem -> elem.stream())
            .collect(Collectors.toList());

        assert(teamLanguages.containsAll(polyglot.getLanguages()));
        assert(teamLanguages.containsAll(busy.getLanguages()));
        assert(teamLanguages.size() == 9);
    }
}

class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}
