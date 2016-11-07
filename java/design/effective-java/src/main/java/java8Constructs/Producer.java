package java8Constructs;

/**
 * Created by shishir.biyyala on 10/25/16.
 */
public interface Producer {

    void run();

    default int func_1() {
        return 1;
    }

    static int func_2() {
        return 2;
    }

}
