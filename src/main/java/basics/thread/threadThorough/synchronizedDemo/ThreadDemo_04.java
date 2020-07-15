package basics.thread.threadThorough.synchronizedDemo;

import java.util.ArrayList;

/**
 * 线程安全
 * 多个线程同时访问一个资源时，会导致程序运行结果并不是想看到的结果。 这个资源被称为 临界资源 (共享资源)
 * 解决方案
 * 在同一时刻 只能有一个线程访问临街资源 (同步互斥访问)
 * 互斥锁:只允许单个线程访问资源
 *
 *
 * synchronized
 * synchronized可以修饰方法 可以修饰类 也可以修饰 代码块
 * 当synchronized修饰方法时 当一个线程访问对象的synchronized方法时 那么其他线程则不能访问该对象的其他synchronized方法 但可以访问调用该对象的非synchronized方法
 * synchronized修饰的方法 实际上是将对象的唯一的一把锁交给了线程 访问非synchronized方法则不需要对象的唯一锁 所以可以访问
 * <p>
 * 对于synchronized方法或者synchronized代码块，当出现异常时，JVM会自动释放当前线程占用的锁，因此不会由于异常导致出现死锁现象。
 * junit
 * <p>
 * synchronized修饰代码块
 *
 * 线程会获取对象synObject的锁，从而使得其他线程无法同时访问该代码块
 * synchronized(synObject)
 * {
 * }
 *
 * Created by sulong on 2019/4/22.
 */
public class ThreadDemo_04 {


    public static void main(String[] args) {
        ThreadDemo_04 threadDemo_04 = new ThreadDemo_04();
        final InserData inserData = threadDemo_04.new InserData();

        new Thread() {
            @Override
            public void run() {
                inserData.insert(Thread.currentThread());
            }

            ;
        }.start();
        new Thread() {
            @Override
            public void run() {
                inserData.insert(Thread.currentThread());
            }

            ;
        }.start();

    }

    class InserData {
        private ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        private Object object = new Object();


        public void insert(Thread thread) {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(thread.getName() + "在插入数据" + i);
                    arrayList.add(i);

                }
            }
        }

    }
}