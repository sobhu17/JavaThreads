package AdderAndSubtractorSynMethod;

public class Subtractor implements Runnable{

    private Value value;
    public Subtractor(Value value){
        this.value = value;
    }

    public void run(){
        for(int i = 1 ; i <= 100000 ; i++){
            synchronized (value){
                value.sub(i);
            }
        }
    }

}
