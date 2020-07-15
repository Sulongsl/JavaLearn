package basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 ExecutorService创建线程池
 * Created by sulong on 2019/1/24.
 */
public class ExcuutorServiceTest {
    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //线程任务对象 其中包含run方法
        // 获取线程池中的某一个线程对象，并执行线程中的 run() 方法
        TashRunnable tashRunnable = new TashRunnable();
        // 从线程池中获取线程对象
        executorService.submit(tashRunnable);
        System.out.println("-------------------");
        //再获取一个线程对象
        executorService.submit(tashRunnable);
        //关闭线程池
        executorService.shutdown();

    }
}
