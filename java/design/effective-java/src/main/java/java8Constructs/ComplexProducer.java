package java8Constructs;

/**
 * Created by shishir.biyyala on 10/25/16.
 */
public class ComplexProducer implements Producer {

    @Override
    public void run() {
        System.out.println(this.func_1());
    }

    public int func_2() {
        return 5;
    }
}
