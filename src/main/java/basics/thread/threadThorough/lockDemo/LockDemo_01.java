package basics.thread.threadThorough.lockDemo;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock是个接口 所以实例化通过创建实现它的类来创建 ReentrantLock类实现
 * lock()   获取锁 如锁被其他线程占用则等待
 * tryLock()    返回boolean获取锁
 * tryLock(long time,timeUnit unit)     可以选择等待时间 返回boolean
 * lockInterruptibly()      获取不到锁则抛出异常并中断线程的等待状态 (即用此方法获取锁获取不到则不会使线程处于等待状态)
 * 以上的方法都是用来获取锁的
 * unLock()
 *
 * ReentranLock Lock的唯一实现类
 *
 * 这里练习了 lock方法 与tryLock()方法
 * Created by sulong on 2019/4/24.
 */
public class LockDemo_01 {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    /**
     * //注意这个地方
     */
    private Lock lock = new ReentrantLock();



    public static void main(String[] args) {
        final LockDemo_01 lockDemo_01 = new LockDemo_01();
        new Thread(){
            @Override
            public void run(){
                lockDemo_01.insert(Thread.currentThread());
            }
        }.start();
        /*
        0得到锁
        0释放了锁
        1得到锁
        1释放锁
         */

        new Thread(){
            @Override
            public void run(){
                lockDemo_01.insert(Thread.currentThread());
            }
        }.start();

    }

    /**
     *
     * @param thread
     */
    public void insert(Thread thread){
        //局部变量 输出结果为两个线程都得到了锁 因为他们获取的是不同的锁  解决方案将lock声明为类属性
        Lock lock=new ReentrantLock();
        lock.lock();
//        if (lock.tryLock()){
            try {
                System.out.println(thread.getName()+"得到了锁");
                for (int i =0;i<1000;i++){
                    arrayList.add(i);
                }

            }catch (Exception e){

            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        }

//    else {
//        System.out.println(thread.getName()+"获取锁失败");
//    }





    }
