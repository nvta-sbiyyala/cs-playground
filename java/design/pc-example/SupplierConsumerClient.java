import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by shishir.biyyala on 10/25/16.
 * Reference: http://www.byteslounge.com/tutorials/java-8-consumer-and-supplier
 */
class User {
    private int id;

    User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

public class SupplierConsumerClient {

    public static void main(String[] args) throws InterruptedException {

        BlockingDeque<User> usersQ = new LinkedBlockingDeque<>();

        Supplier<User> userSupplier = () -> {
            try {
                return usersQ.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Consumer<User> userConsumer = user -> System.out.println("Processing user " + user.getId());

        Supplier<Boolean> conditionSupplier = () -> !usersQ.isEmpty();

        for (int i = 0; i < 100; i++) {
            usersQ.put(new User(i));
        }

        SupplierConsumer job = new SupplierConsumer<>(userSupplier, userConsumer, conditionSupplier);
        job.setText("=============== Job Running on %s ===============");

        final int N = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        for (int i = 0; i < N; i++)
            executorService.execute(job);

        executorService.shutdown();
        executorService.awaitTermination(200, TimeUnit.MILLISECONDS);
    }
}
