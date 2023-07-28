import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 1 ; i <= 100 ; i++){
            if((i == 5) || (i == 11) || (i == 20)){
                System.out.println("debug!!");
            }

            NumberPrinter np = new NumberPrinter(i);
            executor.execute(np);
        }

        // to stop the execution we need to tell executor to stop
        executor.shutdown();
    }
}
