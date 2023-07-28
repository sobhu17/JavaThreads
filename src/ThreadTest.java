public class ThreadTest {
    public static void main(String[] args) {

        HelloWorldPrinter hwp = new HelloWorldPrinter();

        System.out.println("Saurabh Kaushik " + Thread.currentThread().getName());

        Thread t = new Thread(hwp);
        t.start();
    }
}
