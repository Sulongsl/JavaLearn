package basics.gather;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 优先级队列
 * Created by sulong on 2019/1/22.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {

        //构造一个优先级队列
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910, Calendar.JUNE,22));

        System.out.println("Iterating oven elements...");

        //迭代并不是按照元素的排列顺序访问的 ,而删除却总是删掉剩余元素中优先级最小的那个元素
        //可以理解为 该队列的删除规则从创建就已经建立起来了
        for (GregorianCalendar date :pq){
            System.out.println(date.get(Calendar.YEAR));

            System.out.println("Removing elements....");
            while (!pq.isEmpty()){
                System.out.println(pq.remove().get(Calendar.YEAR));
            }
        }
    }
}
