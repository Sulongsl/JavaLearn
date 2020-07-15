package basics.thread.threadThorough.threadPoolExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor中的构造方法含有4种构造方法 但是分析源码都是用
 * <p>
 * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 * BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);
 * 这个构造犯法实现初始化工作的
 * <p>
 * corePoolSize 核心池大小; 除去预创建线程的线程池外 构造线程池后有任务来之后 会创建线程执行任务 当线程数达到cortPoolSize时 未执行的任务会放到缓存队列中等待
 * <p>
 * maximumPoolSize 线程池最大线程数
 * corePoolSize与maximumPoolSize相比较 core是指任务并发数量 而maximumPoolSize则是线程存在数量
 * 以工厂车间为例 默认有10人 某日 任务增多 增加4个人手  那么在这个模型中 corePoolSize 为10 maximumPoolSize 为 14
 * 若 期间任务减少 (有线程出现空闲时 则会去掉4个人手 维持原有的10人)

 * corePoolSize是基础大小 maximumPoolSize 最大线程数
 * <p>
 * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止.
 * <p>
 * unit：参数keepAliveTime的时间单位
 * <p>
 *
 * workQueue:阻塞队列 用来存储等待执行的任务
 * (ArrayBlockingQueue;LinkedBlockingQueue;SynchronousQueue;)
 *
 * <p>
 * threadFactory：线程工厂，主要用来创建线程；
 *
 * handler：表示当拒绝处理任务时的策略，有以下四种取值：
 *
 * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
 * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
 * <p>
 * execute()方法实际上是Executor中声明的方法，在ThreadPoolExecutor进行了具体的实现，这个方法是ThreadPoolExecutor的核心方法，通过这个方法可以向线程池提交一个任务，交由线程池去执行。
 * <p>
 * Created by sulong on 2019/5/10.
 */
public class ThreadPoolExecutorDemo implements Runnable {
    public ThreadPoolExecutorDemo() {

    }

    List<String> list = new ArrayList<>();
    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
    ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    };
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 12, 200,
            TimeUnit.MICROSECONDS, linkedBlockingQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    @Override
    public void run() {

    }
}
