package basics.thread.threadThorough.thread;

/**
 * 5.join()
 *   join(long millis) //参数为毫秒
 *   join(long millis, int nanoseconds) //第一个参数为毫秒 第二个为纳秒
 *
 *   假如在main线程中，调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。
 *   如果调用的是无参join方法，则等待thread执行完毕，如果调用的是指定了时间参数的join方法，则等待一定的时间。
 *
 * Created by sulong on 2019/4/22.
 */
public class ThreadDemo_02 {

    public static void main(String[] args) {
        System.out.println("正在执行主线程"+Thread.currentThread().getName());
        ThreadDemo_02 threadDemo_02=new ThreadDemo_02();
        MtThread m1=threadDemo_02.new MtThread();
        // 这里线程m1仅仅是进入就绪状态 等待获取CPU资源才可以执行
        m1.start();
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"等待");
            m1.join();// 将正在执行的线程wait 阻塞 让m1获取CPU执行
            System.out.println("线程"+Thread.currentThread().getName()+"继续执行");
        }catch (Exception e){
            System.out.println("888");
        }


    }

    class MtThread extends Thread{
        @Override
        public void run(){
            System.out.println("开始执行线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"执行结束");
        }
    }
}
