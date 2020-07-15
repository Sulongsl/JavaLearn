package basics.thread.threadThorough.tongBuRongQi;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWrite容器 即写时复制的容器。
 * 通俗的理解是当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。
 *
 * 应用该类型容器的好处是 对CopyOnWrite容器进行并发读 不需要加锁 当然当多个进程分别进行读写操作时 读到的可能会是老数据
 *
 * 这类的容器含有 CopyOnWriteArrayList 及 CopyOnWriteArraySet
 *
 * 写时复制容器的应用场景
 * 用于读多写少的并发场景
 *
 *
 * Created by sulong on 2019/5/8.
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList();
        CopyOnWriteArrayList<String> list1=new CopyOnWriteArrayList();

        // CopyOnWeiteArrayList 在进行add方法时是加锁的 !!! 读操作没有锁
        Thread thread = new Thread(){
            /**
             * 在实际操作时 尽量减少扩容开销
             * 使用批量添加。因为每次添加，容器每次都会进行复制，所以减少添加次数，可以减少容器的复制次数
             */
            @Override
            public void run(){
                for (int i=0;i<5;i++){
                    boolean th=list1.add(String.valueOf(i));
                }
            }
        };
        thread.start();
        boolean a =list.add("a");
        String b = list.get(0);
        // 因为是写时复制容器 所以会导致读取时拿到的出现数据延迟  可能是0 也可能是5  但是不会出现 1234 因为是写完后才会更改指针
        // CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性
        System.out.println(list1.size());
        System.out.println(list1.size());
        System.out.println(list1.size());
        System.out.println(b+list1.size());
    }



}
