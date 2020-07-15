package basics.thread;

/**
 * Created by sulong on 2019/1/24.
 */
public class ThreadTest extends Thread {
    private Thread t;
    private String threadName;

    ThreadTest (String name){
        threadName=name;
    }
    @Override
    public void run(){
        System.out.println(123);

        try{
            for(int i = 4;i>0;i--){
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("eee");
        }
        System.out.println();
    }
    @Override
    public void start(){
        if (t ==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
