package basics.gather;


import basics.gather.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 * Created by sulong on 2019/1/22.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Employee> staff = new HashMap<>();

        // 插入 键 与 值 到映射表中 如果这个键已经存在 则新插入的对象将取代与这个键对应的就对象
        staff.put("144",new Employee("Lee",21,1994,12,21));
        staff.put("155",new Employee("Jan",99,1667,12,21));
        staff.put("166",new Employee("Ken",33,1884,12,21));

        System.out.println(staff);

        staff.remove("155");

        System.out.println(staff);

        System.out.println(staff.get("166"));

        for (Map.Entry<String,Employee> entry : staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key : " + key + ", value : " + value);
        }
    }
}
