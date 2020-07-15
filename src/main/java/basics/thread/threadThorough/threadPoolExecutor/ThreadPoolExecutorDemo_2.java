package basics.thread.threadThorough.threadPoolExecutor;

import sun.jvm.hotspot.debugger.ThreadProxy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/dolphin0520/p/3932921.html
 * 理解了线程池的构成后 看下它的执行
 * <p>
 * Class ThreadPoolExecutor extends AbstractExecutorService
 * <p>
 * Abstract AbstractExecutorService implements ExecutorService
 * Interface ExecutorService extends Executor
 * interface Executor
 * execute()方法
 * 究其根本就是一个execute方法 执行的
 * 在ThreadPoolExecutor类中 重写了execute
 * <p>
 * 线程池的状态 :
 * 　当创建线程池后，初始时，线程池处于         RUNNING状态；
 * <p>
 * 　　如果调用了shutdown()方法，则线程池处于    SHUTDOWN状态， 此时线程池不能够接受新的任务，它会等待所有任务执行完毕；
 * <p>
 * 　　如果调用了shutdownNow()方法，则线程池处于 STOP状态，     此时线程池不能接受新的任务，并且会去尝试终止正在执行的任务；
 * <p>
 * 　　当线程池处于SHUTDOWN或STOP状态，并且所有工作线程已经销毁，任务缓存队列已经清空或执行结束后，
 * 线程池被设置为  TERMINATED状态。
 * <p>
 * <p>
 * Created by sulong on 2019/5/16.
 */
public class ThreadPoolExecutorDemo_2 {
    /**
     * ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 12, 200,
     * TimeUnit.MICROSECONDS, linkedBlockingQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
     */


    private static ThreadFactory threadProxy;
    private static final ThreadPoolExecutor T = new ThreadPoolExecutor(20, 40, 200, TimeUnit.MICROSECONDS, new LinkedBlockingQueue(10), threadProxy);



    /**
     * 这里 executor方法  线程池 究其根本就是将一个个线程任务交给池中的线程去执行
     * @param command
     */
    public void execute(Runnable command) {

    }
//        if (command == null)
//            throw new NullPointerException();
//        //
//        int c = ctl.get();
//
//        if (workerCountOf(c) < corePoolSize) {
//            if (addWorker(command, true))
//                return;
//            c = ctl.get();
//        }
//        if (isRunning(c) && workQueue.offer(command)) {
//            int recheck = ctl.get();
//            if (! isRunning(recheck) && remove(command))
//                reject(command);
//            else if (workerCountOf(recheck) == 0)
//                addWorker(null, false);
//        }
//        else if (!addWorker(command, false))
//            reject(command);
//    }

//    /**
//     *
//     * @param r
//     */
//    private void executor(Runnable r) {
//        if (r == null)
//            throw new NullPointerException();
//
//        // 若当前线程池中的线程数 不小于 核心线程数  或 addIfUnderCorePoolSize(command) 为false时
//        if (T.getPoolSize() >= T.getCorePoolSize() || !T.addIfUnderCorePoolSize(r)) {
//            if (T.getrunState == RUNNING && workQueue.offer(command)) {
//
//
//            }
//
//        }
//    }
public static void main(String[] args) {

    System.out.println(Integer.SIZE);
}
}
