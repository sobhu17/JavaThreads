package MergeSort;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(
                10, 2, 8, 11, 4, 3, 9, 1
        );

        ExecutorService executor = Executors.newCachedThreadPool();

        Sorter arraySorter = new Sorter(arrayToSort , executor);
        Future<List<Integer>> sortedArrayFuture = executor.submit(arraySorter);

        List<Integer> sortedArray = sortedArrayFuture.get();

        for(int i = 0 ; i < sortedArray.size() ; i++){
            System.out.print(sortedArray.get(i) + " ");
        }

        executor.shutdown();

    }
}
