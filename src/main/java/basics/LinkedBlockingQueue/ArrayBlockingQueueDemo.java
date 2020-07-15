package basics.LinkedBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * ArrayBlockingQueue 基于数组实现的阻塞队列; 创建时需要指定容量大小
 *
 * LinkBlockingQueue  基于链表实现的阻塞队列
 * 以上两种都是先进先出队列 有界
 * PriorityBlockingQueue 是按照元素的优先级进行排序 然后按照顺序出列(优先级由高到低出) 无界的阻塞队列
 * DelayQueue基于peiorityQUeue 延时阻塞队列
 *
 *
 * 阻塞队列的主要方法:
 *
 * offer(E e) 插入队列末尾 插入成功 返回true 插入失败 返回false
 * offer(E e,long timeout,TimeUnit unit) 向队尾存入元素，如果队列满，则等待一定的时间，当时间期限达到时，如果还没有插入成功，则返回false；否则返回true；
 *
 * poll() 移除并获取队列首元素 成功 返回队首元素 否则返回null
 * poll(long timeout, TimeUnit unit)  从队首取元素，如果队列空，则等待一定的时间，当时间期限达到时，如果取到，则返回null；否则返回取得的元素；
 *
 * peek() 获取队首元素，若成功，则返回队首元素；否则返回null
 * Created by sulong on 2019/5/9.
 */
public class ArrayBlockingQueueDemo {
    private BlockingQueue queue;

    private ArrayBlockingQueue arrayBlockingQueue ;
    private LinkedBlockingDeque<String> linkedBlockingDeque;

//    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

//    LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public ArrayBlockingQueueDemo(){

    }
    /**
     * 构造方法
     * @param arrayBlockingQueue
     */
    public ArrayBlockingQueueDemo(ArrayBlockingQueue arrayBlockingQueue){
        this.arrayBlockingQueue=arrayBlockingQueue;
    }

    public ArrayBlockingQueueDemo(LinkedBlockingDeque<String> linkedBlockingDeque){
        this.linkedBlockingDeque=linkedBlockingDeque;
    }

    public ArrayBlockingQueueDemo(BlockingQueue queue){
        this.queue=queue;
    }


    public ArrayBlockingQueue getArrayBlockingQueue() {
        return arrayBlockingQueue;
    }

    public void setArrayBlockingQueue(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    public LinkedBlockingDeque<String> getLinkedBlockingDeque() {
        return linkedBlockingDeque;
    }

    public void setLinkedBlockingDeque(LinkedBlockingDeque<String> linkedBlockingDeque) {
        this.linkedBlockingDeque = linkedBlockingDeque;
    }

    public BlockingQueue getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue queue) {
        this.queue = queue;
    }
    public Integer testCount(){
        return 10;
    }
    public Integer arrayBlockQueueSize(){
        return arrayBlockingQueue.size();
    }

    public Object arrayBlockQueuePoll(){
        return arrayBlockingQueue.poll();
    }
    public Object arrayBlockQueuePeek(){
        return arrayBlockingQueue.peek();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        for (int i=1;i<10;i++){
            if (arrayBlockingQueue.offer(i)){
                System.out.println("offer Success: "+i);
            }
        }
        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        ArrayBlockingQueueDemo arrayBlockingQueueDemo1 = new ArrayBlockingQueueDemo(arrayBlockingQueue);
        System.out.println(arrayBlockingQueueDemo.testCount());
        System.out.println(arrayBlockingQueueDemo1.arrayBlockQueueSize());
        System.out.println(arrayBlockingQueueDemo1.arrayBlockQueuePoll());
        System.out.println(arrayBlockingQueueDemo1.arrayBlockQueueSize());
        System.out.println(arrayBlockingQueueDemo1.arrayBlockQueuePeek());


    }
}
