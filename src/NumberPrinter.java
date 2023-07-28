public class NumberPrinter implements Runnable{

    int numberToPrint;
    public NumberPrinter(int numberToPrint){
        this.numberToPrint = numberToPrint;
    }

    public  void run(){
        System.out.println(numberToPrint + " Print by " + Thread.currentThread().getName());
    }
}
