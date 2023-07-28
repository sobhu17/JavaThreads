public class PrintNumberTest {
    public static void main(String[] args) {

//        problem with this is we are creating new thread for each number which takes memory and time too
//        find a way to reuse the threads to complete task, So for this we use executor

        for(int i = 1 ; i <= 100 ; i++){
            NumberPrinter np = new NumberPrinter(i);

            Thread t = new Thread(np);
            t.start();
        }
    }
}
