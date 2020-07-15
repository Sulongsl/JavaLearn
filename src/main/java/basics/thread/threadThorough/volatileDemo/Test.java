package basics.thread.threadThorough.volatileDemo;

import java.math.BigDecimal;

/**
 * volatile关键字
 *  对一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的(使用volatile关键字会强制将修改的值立即写入主存 并清空所有工作内存值的有效性)
 *
 *  MESI缓存一致性协议 (仅在写入的时候加锁)
 *
 *  禁止进行指令重排序。
 *
 * Volatile从来就不是用来保证操作原子性的关键字，他只负责保证可见性和有序性，他的原子性是需要依靠锁来保证的。
 *
 * 其实他也有一定的原子性，单个volatile变量的读操作和写操作是具有原子性的，但是一旦拥有多个操作，不再保证原子性
 *
 * Created by sulong on 2019/4/25.
 */
public class Test {
    public int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
//        final Test test = new Test();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                @Override
//                public void run() {
//                    for(int j=0;j<10;j++)
//                        test.increase();
//                };
//            }.start();
//        }
//
//        while(Thread.activeCount()>1)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc); 读取(读到的并不一样) 赋值 赋值 写入主内存 几个操作加起来并不是原子操作

        double amountD = Double.parseDouble("0.00028") * 100;
        double amountb = Double.valueOf("34.8") * 100;
        BigDecimal a = new BigDecimal("39.8");
        BigDecimal b = new BigDecimal(Double.toString(100));

        System.out.println( a.multiply(b).doubleValue());
        System.out.println(amountD);
        System.out.println(amountb);

    }
}
