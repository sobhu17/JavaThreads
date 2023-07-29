package AdderAndSubtractorProblem;

public class Subtractor implements Runnable{

    Value value;
    public Subtractor(Value value){
        this.value = value;
    }

    public void run(){
        for(int i = 1 ; i <= 10000 ; i++){
            value.val -= i;
        }
    }

}
