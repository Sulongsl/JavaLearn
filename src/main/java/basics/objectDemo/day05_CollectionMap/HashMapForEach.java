package basics.objectDemo.day05_CollectionMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  * HashMap 遍历
 * Created by sulong on 2019/4/15.
 */
public class HashMapForEach {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","nick");
        map.put("age","22");
        map.put("sex","1");


        /**
         * 普遍方法  二次取值
         */
        for (String key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }

        /**
         * 通过Map.entrySet使用iterator遍历key和value
         */
        Iterator<Map.Entry<String,String>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()){
            Map.Entry<String,String > entry = iterable.next();
            System.out.println(entry.getKey()+" " +entry.getValue());
        }
        /**
         * 推荐，尤其是容量大时
         */
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        /**
         * 通过mao.values()遍历所以value但不能遍历key
         */
        for (String v:map.values()){
            System.out.println(v);
        }


    }
}
