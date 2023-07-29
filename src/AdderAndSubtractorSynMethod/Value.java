package AdderAndSubtractorSynMethod;

public class Value {
    public int val;

    synchronized public void add(int v){
        val += v;
    }
    synchronized public  void sub(int v){
        val -= v;
    }

}
