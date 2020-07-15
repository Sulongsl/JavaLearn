package basics.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sulong on 2019/1/31.
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    /**
     * 构造函数
     * @param queue
     */
    public Consumer(BlockingQueue<String> queue){
        this.queue=queue;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("启动消费者线程");
        Random r = new Random();
        boolean isRunning = true;
        try {
            while (isRunning){
                System.out.println("正在从队列获取数据");
                // 有数据时从队列首取走,无数据时发生阻塞,在2s内有数据 取走 超出2s无数据 退出消费者线程
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null !=data){
                    System.out.println("拿到数据"+ data);
                    System.out.println("增在消费数据" + data);
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                }else {
                    //超出2S还是没有数据 所有生产者线程都有经退出,自动退出消费线程
                    isRunning=false;
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("退出消费者线程");
        }
    }
}
