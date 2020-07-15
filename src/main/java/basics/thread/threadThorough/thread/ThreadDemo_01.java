package basics.thread.threadThorough.thread;

/**
 * thread类中常用的方法
 * 1.start()      //启动一个新线程
 * 2.run()     //这个方法是不需要用户来调用的 通过start()启动线程后 当线程获取了CPU执行时间后 自动进入run()执行方法体
 *
 * 3.sleep(long millis)    //参数为毫秒
 *   sleep(long millis, int nanoseconds)   //第一个参数为毫秒 第二个为纳秒
 *   交出CPU 去执行其他任务  不会释放对象的锁
 *
 * 4. yield() 当前线程交出CPU权限，让CPU去执行其他的线程 与sleep相似不会释放锁
 *
 *
 * Created by sulong on 2019/4/22.
 */
public class ThreadDemo_01 {

    private int i = 10;
    private Object object = new Object();



    public static void main(String[] args) {
        ThreadDemo_01 threadDemo_01 = new ThreadDemo_01();
        MyThread thread_1 = threadDemo_01.new MyThread();
        MyThread thread_2 = threadDemo_01.new MyThread();
        thread_1.start();
        thread_2.start();

    }

    /**
     * iY:11(Thread-0) //0拿到对象i
       线程Thread-0进入睡眠状态 // 睡
       线程Thread-0睡眠结束
       i:14(Thread-0)
       iY:12(Thread-1) // 1拿到对象i 只有等待0处理完	后才拿到对象的锁 也就是说当0线程去睡眠后没有释放对象锁 1线程也就无法执行任务
       线程Thread-1进入睡眠状态 1
       线程Thread-1睡眠结束
       i:13(Thread-1)
     */
    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("iY:" + i+"("+Thread.currentThread().getName()+")");
            }
            try{
                System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("888");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
            i++;
            System.out.println("i:" + i+"("+Thread.currentThread().getName()+")");

        }
}
}
