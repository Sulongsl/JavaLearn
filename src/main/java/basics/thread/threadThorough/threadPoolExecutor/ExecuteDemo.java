package basics.thread.threadThorough.threadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，
 *    这样频繁创建线程就会大大降低系统的效率，因为频繁创建线程和销毁线程需要时间。
 *
 *
     public void execute(Runnable command) {
        if (command == null)
        throw new NullPointerException();

        int c = ctl.get();
        if (workerCountOf(c) < corePoolSize) {
        if (addWorker(command, true))
        return;
        c = ctl.get();
        }
        if (isRunning(c) && workQueue.offer(command)) {
        int recheck = ctl.get();
        if (! isRunning(recheck) && remove(command))
        reject(command);
        else if (workerCountOf(recheck) == 0)
        addWorker(null, false);
        }
        else if (!addWorker(command, false))
        reject(command);
        }
 * 对 PoolExecutor类中的 Exexute方法 解析
 *
 * Created by sulong on 2019/5/29.
 */
public class ExecuteDemo {

    /**
     *  Integter.SIZE = 32  用来以二进制补码形式表示 int 值的比特位数。
     */
    private static final int COUNT_BITS = Integer.SIZE - 3;

    /**
     * 容量 536870909
     */
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;


    /**
     * 定义了一些线程池状态码
     *
     * https://www.cnblogs.com/chuijingjing/p/9405598.html
     * 移位运算符  <<表示左移移，不分正负数，低位补0；
     *           >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
     *           >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0、
     */
    //高3位111 该状态的线程池会接收新任务，并处理阻塞队列中的任务
    private static final int RUNNING    = -1 << COUNT_BITS;
    //该状态的线程池不会接收新任务，但会处理阻塞队列中的任务
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    /**
     * 用于存放待执行任务的阻塞队列
     */
    private final BlockingQueue<Runnable> workQueue;


    /**
     * 定义一个 AtomicInteger (-536870912)
     * 利用低29位表示线程池中线程数，通过高3位表示线程池的运行状态
     *
     *
     *  定义一个保证线程安全的全局变量
     *  多线程访问则 ctl变量会在主内存中保证更新
     *  AtomicInteger -> volatile关键字
     */
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    /**
     * 核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
     *  volatile关键字
     */
    private volatile int corePoolSize;

    /**
     * 饱和策略
     */
    private volatile RejectedExecutionHandler handler;

    /**
     *
     * @param workQueue
     * @param corePoolSize
     * @param handler
     */
    public ExecuteDemo(BlockingQueue<Runnable> workQueue, int corePoolSize, RejectedExecutionHandler handler) {
        this.workQueue = workQueue;
        this.corePoolSize = corePoolSize;
        this.handler = handler;
    }


    /**
     * 处理任务饱和后的方法
     * @param command
     */
    final void reject(Runnable command) {
//        handler.rejectedExecution(command, this);
    }




    /**
     * 传入一个线程任务 进行处理
     * @param command
     */
        public void execute(Runnable command) {
            if (command ==null) throw new NullPointerException();

            // 获取 ctl 的 值value
            int c = ctl.get();

            // ①逻辑判定 workerCountOf(c) 表示当前在运行的线程数  当 新任务传入 当前线程数少于corePollSize时 启动一个新线程来执行 command
            if (workerCountOf(c) < corePoolSize) {
                // 执行成功 返回
                if (addWorker(command, true))  return;

                // 再次获取 当前线程数
                c = ctl.get();
            }
            // ② 当处于RUNNING并且 阻塞队列未满时
            if (isRunning(c) && workQueue.offer(command)) {
                // 获取下线程数
                int recheck = ctl.get();
                // 2.5 当线程池状态不是处于running状态时 或 队列中移除指定任务失败时
                if (! isRunning(recheck) && remove(command))
                    // 抛出 异常
                    reject(command);
                // 当处于运行中的线程数为0
                else if (workerCountOf(recheck) == 0)
                    //创建新的线程去阻塞队列中的任务来执行
                    addWorker(null, false);

            }
            //
            else if (!addWorker(command, false))
                reject(command);
            }

    /**
     * 判定 当前运行的线程池 是否处于RUNNING状态
     * @param c
     * @return
     */
    private boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    /**
     * 启动一个新线程 执行任务
     * @param command
     * @param b
     * @return
     */
    private boolean addWorker(Runnable command, boolean b) {
        return false;
    }

    /**
     * 从队列中移除指定任务
     * @param task
     * @return
     */
    public boolean remove(Runnable task) {
        boolean removed = workQueue.remove(task);
        tryTerminate(); // In case SHUTDOWN and now empty
        return removed;
    }

    /**
     *
     */
    final void tryTerminate() {
        return;

    }

    /**
     *
     *
     *
     * 当做逻辑符使用 返回 boolean
     * | 逻辑符 前后两个操作都会执行
     * ||      当左边操作判断为true后 则右边不会执行
     * 同理 & 与 &&
     *
     * 当做位运算符使用 返回 int
     * | 两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。 返回这个数
     * & 两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。      返回这个数
     * @param rs
     * @param wc
     * @return
     */
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    /**
     * 正在工作中的线程池中的线程
     * 判断 刚刚获取的
     * 同理 & 与 &&
     * @param c
     * @return
     */
    private static int workerCountOf(int c)  { return c & CAPACITY; }


    public static void main(String[] args) {

        System.out.println(-1<< 29);
        System.out.println(ctlOf(-1 << COUNT_BITS,0));
    }

}
