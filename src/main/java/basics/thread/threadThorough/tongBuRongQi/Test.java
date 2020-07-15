package basics.thread.threadThorough.tongBuRongQi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Java ConcurrentModificationException异常原因和解决方法
 * Created by sulong on 2019/5/7.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2)
                list.remove(integer);// 这里会抛出异常
            iterator.remove();   //Y用terator中的remove方法处理解决

        }
    }
}
