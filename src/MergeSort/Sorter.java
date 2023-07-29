package MergeSort;
import java.util.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executor;

    public Sorter(List<Integer> arrayToSort , ExecutorService executor){
        this.arrayToSort = arrayToSort;
        this.executor = executor;
    }

    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i = 0 ; i < mid ; i++){
            leftArray.add(arrayToSort.get(i));
        }

        for(int i = mid ; i < arrayToSort.size() ; i++){
            rightArray.add(arrayToSort.get(i));
        }

        Sorter leftArrayToSort = new Sorter(leftArray , executor);
        Sorter rightArrayToSort = new Sorter(rightArray , executor);

        Future<List<Integer>> leftSortedArrayFuture = executor.submit(leftArrayToSort);
        Future<List<Integer>> rightSortedArrayFuture = executor.submit(rightArrayToSort);

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        List<Integer> sortedArray = new ArrayList<>();
        int i = 0;
        int j = 0;


        while((i < leftSortedArray.size()) && (j < rightSortedArray.size())){
            if(leftSortedArray.get(i) <= rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }
            else{
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return sortedArray;
    }

}
