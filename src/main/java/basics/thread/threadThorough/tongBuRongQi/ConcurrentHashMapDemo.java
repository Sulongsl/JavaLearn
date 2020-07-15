package basics.thread.threadThorough.tongBuRongQi;

import sun.jvm.hotspot.utilities.HashtableEntry;

import javax.swing.text.Segment;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://www.cnblogs.com/dolphin0520/p/3932905.html
 * 同步容器只是保证了线程的安全但是却严重降低了吞吐量
 *
 *
 *
 * 并发容器 ConcurrentHashMap   (同步容器 HashTable Vector是使用synchronized来保证线程安全 效率低)
 * 1.定义了一些并发安全的复合操作，2.定义了一些并发安全的符合性操作,并且保证并发环境下的迭代操作不会出错。
 *
 * hashMap ,ArrayList,LinkedList都是非线程安全
 * 有多个线程并发地访问这些容器时，就会出现问题。
 *
 * ConcurrentHashMap (并发HashMap)
 * 内部采用 Segment 结构
 *
 * 一个Segment 其实就是一个类HashTable的结构
 *
 * ConcurrentHashMap的get操作是不用加锁的
 * put和remove应用的Segment中的方法
 *
 * 在java8中 HashMap和COncurrentHashMap增加了红黑树结构
 *
 *
 *
 * Created by sulong on 2019/5/7.
 */
public class ConcurrentHashMapDemo {




    ConcurrentHashMap concurrentHashMap;

    //初始化方法 public ConcurrentHashMap(int initialCapacity初始的容量,float loadFactor负载参数, int concurrencyLevel内部的Segment的数量)


}
