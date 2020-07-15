package basics.objectDemo.day03_OverrideAndOverload.duoTai.test;

/**
 * Created by sulong on 2019/4/4.
 */
public class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    /**
     * 重写A中的第二个方法
     * @param obj
     * @return
     */
    @Override
    public String show(A obj){
        return ("B and A");
    }
}
