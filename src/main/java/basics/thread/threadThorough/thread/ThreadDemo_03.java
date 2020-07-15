package basics.thread.threadThorough.thread;

/**
 * 7.interrupt方法
 *  无法中断非阻塞状态下的线程
 *  调用interrupt方法可以让处于阻塞状态的线程抛出一个异常 也就是用来中断一个阻塞状态的线程
 *  isInterrupt()
 *
 * 8.getId()
 * 9.getName and setName
 * 10.getPriority and setPriority 获取和设置线程优先级
 *
 * 11.setDaemon和isDaemon 获取和设置是否为守护线程
 *  守护线程依赖于创建它的线程 当主线程运行完毕后 守护线程也会随着消亡 而用户线程则不会
 *
 * Created by sulong on 2019/4/22.
 */
public class ThreadDemo_03 {
    public static void main(String[] args) {
        ThreadDemo_03 test = new ThreadDemo_03();
        MyThread thread = test.new MyThread();
        thread.start();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        //在主线程睡眠完2000毫秒后 对thread进行了中断
        thread.interrupt();

    }
    class MyThread extends Thread{
        // 一般在线程类增加属性来控制中断线程
        private volatile boolean isStop=false;

        public void setStop(boolean stop) {
            isStop = stop;
        }

        @Override
        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+ "进入睡眠状态");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+"睡眠完毕");

            }catch (InterruptedException e){
                System.out.println("中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }
}
