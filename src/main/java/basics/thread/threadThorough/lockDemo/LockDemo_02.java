package basics.thread.threadThorough.lockDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * ReadWriteLock 接口 读写锁  (正常来说 读与读多线程访问不影响 但是写操作就不可以多线程访问了)
 * ReentrantReadWriteLock 实现读写锁的类
 *
 *
 * 如果有一个线程已经占用了 读锁，则此时 其他线程 如果要 申请写锁，则 申请写锁的线程会一直等待释放读锁。


 　如果有一个线程已经占用了 写锁，则此时 其他线程 如果 申请写锁或者读锁，则 申请的线程会一直等待释放写锁。

 * Created by sulong on 2019/4/25.
 */
public class LockDemo_02 {
    private static ReentrantReadWriteLock  reentrantReadWriteLock= new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final LockDemo_02 test = new LockDemo_02();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    private void get(Thread thread) {
        reentrantReadWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");

        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

}
