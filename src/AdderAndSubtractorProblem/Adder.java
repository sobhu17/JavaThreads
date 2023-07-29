package AdderAndSubtractorProblem;

public class Adder implements Runnable{

    Value value;

    public  Adder(Value value){
        this.value = value;
    }

    public void run(){
        for(int i = 1 ; i <= 10000 ; i++){
            value.val += i;
        }
    }
}
