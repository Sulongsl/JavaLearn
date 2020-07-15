package basics.gather;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链表 LinkedList
 * Created by sulong on 2019/1/18.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Bay");
        a.add("Car");
        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // 返回一个列表迭代器 用来访问列表中的元素
        ListIterator<String> aIterator = a.listIterator();
        Iterator<String> bIterator = b.iterator();

        while (bIterator.hasNext()){
            if (aIterator.hasNext()){
                aIterator.add(bIterator.next());
            }
        }

        System.out.println(a);

        bIterator = b.iterator();
        while (bIterator.hasNext()){
            bIterator.next();
            if (bIterator.hasNext()){
                bIterator.next();
                bIterator.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);
    }
}
