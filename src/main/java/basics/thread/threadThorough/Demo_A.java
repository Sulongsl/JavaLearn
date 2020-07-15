package basics.thread.threadThorough;

/**
 *  线程的创建
 *       继承Thread类 (必须重写run方法)
 *       实现Runnable接口
 * 说白了就是实现Runnable接口
 *
 * Created by sulong on 2019/4/19.
 */
public class Demo_A extends Thread{
    private static int num=0;

    public Demo_A(){
        num++;
    }

    /**
     * run方法中只是定义需要执行的任务
     */
    @Override
    public void run(){
        System.out.println("主动创建的第"+num+"线程");
    }

    /**
     * 创建好线程类后 调用start()方法运行run中方法体
     * 如果直接调用run()方法的话 = 直接在主线程上执行run方法 和普通单线程没有区别
     * @param args
     */
    public static void main(String[] args) {
        Demo_A  a =new Demo_A();
        a.start();
    }

}


