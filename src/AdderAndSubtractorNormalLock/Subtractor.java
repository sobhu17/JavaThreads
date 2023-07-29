package AdderAndSubtractorNormalLock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    private Value value;
    private Lock lock;
    public Subtractor(Value value , Lock lock){
        this.value = value;
        this.lock = lock;
    }

    public void run(){
        for(int i = 1 ; i <= 100000 ; i++){
            lock.lock();
            value.val -= i;
            lock.unlock();
        }
    }

}
