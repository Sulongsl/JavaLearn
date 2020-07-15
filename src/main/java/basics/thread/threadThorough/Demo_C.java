package basics.thread.threadThorough;

/**
 * 通过实现Runnable接口的方式 实现线程类
 * 因为Java只能单继承 所以有些需要使用该实现方式
 * Created by sulong on 2019/4/19.
 */
public class Demo_C implements Runnable{
    @Override
    public void run() {
        System.out.println("线程ID:"+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println("主线程ID："+Thread.currentThread().getId());// 主线程ID:1
        Demo_C c = new Demo_C();
        // 这种方式必须将Runnable作为Thread类的参数 然后执行start方法
        Thread thread = new Thread(c);
        thread.start(); // 线程ID:10
        c.run();//线程ID:1
    }
}
