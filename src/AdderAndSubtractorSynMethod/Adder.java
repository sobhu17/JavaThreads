package AdderAndSubtractorSynMethod;

public class Adder implements Runnable{

    private Value value;
    public  Adder(Value value){
        this.value = value;
    }

    public void run(){
        for(int i = 1 ; i <= 100000 ; i++){
            synchronized (value){
                value.add(i);
            }
        }
    }
}
