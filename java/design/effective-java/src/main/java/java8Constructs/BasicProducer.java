package java8Constructs;

import java.util.function.Supplier;

/**
 * Created by shishir.biyyala on 10/25/16.
 */
public class BasicProducer implements Producer {

    public static void main(String[] args) {
        Producer producer_1 = new BasicProducer();
        producer_1.run();
        ComplexProducer producer_2 = new ComplexProducer();
        producer_2.run();

        Supplier<Integer> func_2 = Producer::func_2;
        System.out.println(func_2.get());

    }

    @Override
    public void run() {
        System.out.println(this.func_1());
    }
}
