package basics.thread;

import java.util.concurrent.Callable;

/**
 *
 * Created by sulong on 2019/1/24.
 */
public class TashRunnable implements Callable<Object> {
    @Override
    public Object call(){
        System.out.println("Go go");
        int a = 0;
        for (int i =0;i<100;i++){
        System.out.println("自定义线程任务执行主题"+i);
            a = a+i;
        }
        return a;

    }
}
