package basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Callable创建线程池
 * Created by sulong on 2019/1/24.
 */
public class CallableTest {
    public static void main(String[] args) {
        //创建一个线程池 数量为3
        ExecutorService service = Executors.newFixedThreadPool(2);

        TashRunnable c = new TashRunnable();
        //将 执行对象加入线程池 执行
        service.submit(c);
        System.out.println("我是分割线----------");
        // 将执行对象再次加入线程池
        service.submit(c);
        // 获取执行结果 也就是call方法返回的结果
        System.out.println(c.call());
        // 输出结果有3个 99
        service.isShutdown();

    }
}
