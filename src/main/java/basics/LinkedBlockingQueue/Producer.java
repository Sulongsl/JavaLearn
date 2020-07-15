package basics.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * Created by sulong on 2019/1/31.
 */
public class Producer implements Runnable {

    // 是否在运行标识
    private volatile boolean isRunning = true;
    //阻塞队列
    private BlockingQueue queue;
    //自动更新的值
    private static AtomicInteger count = new AtomicInteger();

    private static final int DEFSULT_RANGE_FOR_SLEEP = 1000;

    /**
     * 构造函数
     * @param queue
     */
    public Producer(BlockingQueue queue){
        this.queue=queue;
    }


    /**
     * 主函数
     */
    @Override
    public void run() {
        String data = null;
        Random r = new Random();

        System.out.println("启动生产者线程!");
        try{
            while (isRunning){
                System.out.println("正在生产数据");
                // 取 0~DEFAULT的一个随机数
                Thread.sleep(r.nextInt(DEFSULT_RANGE_FOR_SLEEP));
                // 以原子方式给count 加 1
                data = "data" + count.incrementAndGet();
                System.out.println("将数据:"+data+"放入队列。。。");
                //设定等待时间为2s  如果超出2s还没有加进去就返回 false
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("放入数据失败:" + data);
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();

        }finally {

            System.out.println("退出生产者线程!");
        }
    }
    public void stop(){
        isRunning = false;
    }
}
