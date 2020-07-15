package basics.thread;

/**
 * // 该类实现了Rubbable接口的Run方法
 *
 * 一般会将该类独立开来 在其他方法或函数中调用该类 执行start  --> run方法
 *
 * Created by sulong on 2019/1/23.
 */
class RunnableTest implements Runnable {
    private Thread t;
    private String threadName;

    /**
     * 类的构造方法
     * @param name
     */
    RunnableTest(String name) {
        threadName = name;
        System.out.println("Creating :" + threadName);
    }

    /**
     * 重写Runnable中的run方法
     */
    @Override
    public void run() {
        System.out.println("Running :" + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread :" + threadName + "," + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread :" + threadName + "interrupted");
        }finally {
            Thread.dumpStack();
        }
        System.out.println("Thread :" + threadName + "  exiting");
    }

    public void start() {
        System.out.println("Starting :" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}
