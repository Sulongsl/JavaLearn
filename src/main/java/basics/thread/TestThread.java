package basics.thread;

/**
 * Created by sulong on 2019/1/23.
 */
public class TestThread {
    public static void main(String[] args) {
        RunnableTest R1 = new RunnableTest("T_1");
        R1.start();

//        RunnableTest R2 = new RunnableTest("T_2");
//        R2.start();

//        ThreadTest R3 = new ThreadTest("T_3");
//        R1.start();
//
//        ThreadTest R4 = new ThreadTest("T_4");
//        R2.start();
    }
}
