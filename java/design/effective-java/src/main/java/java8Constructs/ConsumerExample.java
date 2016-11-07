package java8Constructs;

import java.util.function.Consumer;

/**
 * Created by shishir.biyyala on 10/25/16.
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = ConsumerExample::printNames;
        Consumer<String> stringConsumer1 = s -> System.out.println(s);

        stringConsumer.accept("Jeremy");
        stringConsumer.accept("Paul");
        stringConsumer.accept("Richard");

        stringConsumer1.accept("Shishir");
        stringConsumer1.accept("Biyyala");
        stringConsumer1.accept("Bakshi");
    }

    private static void printNames(String s) {
        System.out.println(s);
    }
}
