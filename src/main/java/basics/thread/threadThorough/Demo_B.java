package basics.thread.threadThorough;

/**
 * 用来分清start方法与run方法的执行区别
 * Created by sulong on 2019/4/19.
 */
public class Demo_B extends Thread{
    private String name;

    public Demo_B(String name){
        this.name=name;
    }

    /**
     * 打印子线程Id的Run方法
     */
    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }

    /**
     *   主线程ID:1
         name:B 子线程ID:1
         name:A 子线程ID:10

       a执行start()换了子线程执行
       b执行run() 仍在主线程上跑
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        Demo_B a =new Demo_B("A");
        Demo_B b =new Demo_B("B");
        //在一定的数量基础内 多线程不一定比主线走的快
        a.start();
        a.run();
        b.run();
    }
}
