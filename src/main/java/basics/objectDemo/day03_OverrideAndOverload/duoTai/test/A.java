package basics.objectDemo.day03_OverrideAndOverload.duoTai.test;

/**
 * Created by sulong on 2019/4/4.
 */
public class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
}
