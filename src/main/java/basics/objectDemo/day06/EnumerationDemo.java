package basics.objectDemo.day06;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 枚举类
 * Enumeration接口中定义的方法 通过这些方法可以枚举(一次获得一个)对象集合中的元素
 * 可用迭代器取代
 * Created by sulong on 2019/4/15.
 */
public class EnumerationDemo {
    public static void main(String[] args) {
        Enumeration days;
        //Vector是一个动态数组类 与ArrayList相似
        // 但是 Vector是同步访问
        // 用于事先不知道数组大小
        Vector dayNames =new Vector();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");


        days=dayNames.elements();
        // 测试此枚举是否包含更多的元素。
        while (days.hasMoreElements()){
            //如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
            System.out.println(days.nextElement());
        }
    }
}
