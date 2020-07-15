package basics.thread.threadThorough.synchronizedDemo;

/**
 * 每个类也有一个锁 可以控制对staic数据成员的并发访问
 *
 * Created by sulong on 2019/4/24.
 */
public class ThreadDemo_05 {
    public static void main(String[] args)  {
        ThreadDemo_05 th = new ThreadDemo_05();
        final InsertData insertData = th.new InsertData();
        new Thread(){
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
//                insertData.insert1();
            }
        }.start();
    }
    
    class InsertData{

        public synchronized void insert() {
            System.out.println("执行insert");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行insert完毕");
        }
//
//        // 修饰非法
//        public synchronized static void insert1() {
//            System.out.println("执行insert1");
//            System.out.println("执行insert1完毕");
//        }
    }
}
