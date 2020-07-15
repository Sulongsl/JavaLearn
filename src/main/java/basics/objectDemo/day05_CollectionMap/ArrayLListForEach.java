package basics.objectDemo.day05_CollectionMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList 遍历
 * Created by sulong on 2019/4/12.
 */
public class ArrayLListForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        /**
         * foreach遍历
         */
        for (String s:list){
            System.out.println(s);
        }

        /**
         * 转数组遍历
         */
        String[] strArray = new String[list.size()];
        list.toArray(strArray);

        for (int i=0;i<strArray.length;i++){
            System.out.println(strArray[i]);
        }

        /**
         * 迭代器
         */
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
    }



}
