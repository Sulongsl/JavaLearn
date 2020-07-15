package basics.thread.threadThorough.threadLocalDemo;

/**
 * ThreadLocal 类
 * 1.get()方法 用来获取ThreadLocal保存当前线程的变量副本的
 *
 * 2.set()方法 用来设置当前线程中变量的副本
 *
 * 3.remove()
 *
 * 　　最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
 *
 *
 * Created by sulong on 2019/4/29.
 */
public class ThreadLocalDemo {
    ThreadLocal<Long> longThreadLocal=new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();


    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }


//    lanmbda = (s)-> System.out.println(s);


    public static void main(String[] args) throws InterruptedException {

        final ThreadLocalDemo test = new ThreadLocalDemo();


        //通过ThreadLocal创建的副本存储是在每一个线程内部单独存在的
        test.set();
        System.out.println("main线程:"+test.getLong());
        System.out.println("main线程:"+test.getString());

        Thread thread=new Thread(){
            @Override
            public void run(){
                test.set();
                System.out.println(  "新线程 :"+test.getLong());
                System.out.println( "新线程 :"+test.getString());
            }
        };
        thread.start();
        thread.join();



        //这里输出的仍然是主线程存储的线程信息  新建的线程并不会影响其他线程中的变量
        System.out.println(test.getLong());
        System.out.println(test.getString());

    }
}
