import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by shishir.biyyala on 10/25/16.
 */
public class SupplierConsumer<T> implements Runnable {

    private Supplier<T> supplier;
    private Supplier<Boolean> conditionSupplier;
    private Consumer<T> consumer;
    private String text;

    public SupplierConsumer(Supplier<T> supplier,
                            Consumer<T> consumer,
                            Supplier<Boolean> conditionSupplier) {
        this.supplier = supplier;
        this.consumer = consumer;
        this.conditionSupplier = conditionSupplier;
    }

    @Override
    public void run() {
        while (conditionSupplier.get()) {
            System.out.println(String.format(text, Thread.currentThread().getName()));
            T item = supplier.get();
            consumer.accept(item);
        }
    }

    public void setText(String text) {
        this.text = text;
    }
}
