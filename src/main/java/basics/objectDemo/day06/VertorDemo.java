package basics.objectDemo.day06;

import java.util.Vector;

/**
 * 向量 Vector
 * 和传统数组非常相似 但是Vector的大小可以动态变化
 *
 * Vector()    //第一种构造方法创建一个默认的向量，默认大小为10
   Vector(int size)    //第二种构造方法创建指定大小的向量
   Vector(int size,int incr)    //第三种构造方法创建指定大小的向量，并且增量用incr指定. 增量表示向量每次增加的元素数目
   Vector(Collection c)    //第四中构造方法创建一个包含集合c元素的向量

 * Created by sulong on 2019/4/15.
 */
public class VertorDemo {
    public static void main(String[] args) {
        ////第三种构造方法创建指定大小的向量，并且增量用incr指定. 增量表示向量每次增加的元素数目
        Vector vector=new Vector(3,2);
        System.out.println(vector.size());
        //返回此向量的当前容量。
        System.out.println(vector.capacity());
    }
}
