package AdderAndSubtractorProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Value value = new Value();
        value.val = 0;

        Adder add = new Adder(value);
        Subtractor sub = new Subtractor(value);

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(add);
        executor.execute(sub);

        executor.shutdown();
        executor.awaitTermination(100 , TimeUnit.MINUTES);

        System.out.println(value.val);

//        expected result is zero
//        but we are getting some random values which is because of synchronization problem.!!!

    }
}
