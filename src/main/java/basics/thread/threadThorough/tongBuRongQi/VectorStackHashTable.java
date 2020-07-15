package basics.thread.threadThorough.tongBuRongQi;

import java.util.Collections;
import java.util.Vector;

/**
 * 同步容器:
 * ①Vector、Stack、HashTable
 * ②Collections类中静态工厂方法创建的类
 *
 * 这里Collection是接口 Collections类是一个工具提供类 如对集合或者容器进行排序、查找等 包含了很多静态方法
 *
 * List、Set、Queue 都是继承了Collection接口的容器框架
 * 数组、 集合 和队列 三大容器
 *
 * 像ArrayList、LinkedList、HashMap 这些容器都是非线程安全的。
 * 有多个线程并发地访问这些容器时，就会出现问题。
 *
 *
 * Created by sulong on 2019/5/6.
 */
public class VectorStackHashTable {
    Collections collections;
    /*
    Vector实现可List接口  但是Vector中的方法都是synchronized方法
    Stack继承了Vector类 该类中的方法也是synchronized方法
    HashTable实现了Map接口
     */

    static Vector<Integer> vector = new Vector<>();

    /**
     * 同步容器并不是100%安全的
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        while (true){
            for (int i=0;i<10;i++){
                vector.add(i);

                Thread thread1=new Thread(){
                    @Override
                    public void run(){
                        synchronized (VectorStackHashTable.class) {

                            for (int i = 0; i < vector.size(); i++)
                                vector.remove(i);
                        }

                    };
                };
                Thread thread2= new Thread(){
                    @Override
                    public void run(){
                        synchronized (VectorStackHashTable.class){
                            for (int i=0;i<vector.size();i++)
                                vector.get(i);
                        }


                    };
                };

                thread1.start();
                thread2.start();
                while (Thread.activeCount()>10){

                }

            }


        }

    }
}
