package basics.LinkedBlockingQueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sulong on 2019/1/31.
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        Producer producer1= new Producer(queue);
        Producer producer2= new Producer(queue);
        Producer producer3= new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        Thread.sleep(10 *1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);
        service.shutdown();

    }
}
