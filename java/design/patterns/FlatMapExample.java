import java.util.*;
import java.util.stream.*;

public class FlatMapExample {
    
    public static void main(String[] args) {
        
        Optional<Optional<String>> s1 = Optional.of(Optional.of("Functional java is "));

        System.out.println(s1.flatMap(FlatMapExample::getOutputOpt).orElse("Default"));
        System.out.println(s1.map(FlatMapExample::getOutputString));

        System.out.println(Optional.of("Functional java is ").map(x -> Optional.of(x + "awesome!")).orElse(Optional.empty()));
        System.out.println(Optional.of("Functional java is ").map(x -> Optional.of(x + " awesome!")).orElse(Optional.empty()).orElse("Default"));

    }

    /**
     * Warning: Passing in optionals as arguments is an anti-pattern
     * Being done just as an example for method reference
     */
    static Optional<String> getOutputOpt(Optional<String> input) {
        return input.map(x -> String.format("%s awesome!", x));
    }

    /**
     * Warning: Passing in optionals as arguments is an anti-pattern
     * Being done just as an example for method reference
     */
    static String getOutputString(Optional<String> input) {
        return input.map(x -> String.format("%s awesome!", x)).orElse("Default");
    }

}
