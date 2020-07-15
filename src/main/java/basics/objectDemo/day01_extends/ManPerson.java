package basics.objectDemo.day01_extends;

/**
 * 子类Demo
 * Created by sulong on 2019/4/2.
 */
public class ManPerson extends Person {

    public static void looking(){
        System.out.println("子类不能重写父类的静态方法," +
                "若子类与父类有一个与其方法名，参数类型，参数个数都一样的方法," +
                "则会根据调用对象的不同分别加载这两个静态方法");
    }

    public static void main(String[] args) {
        Person.looking();
        ManPerson.looking();
    }
}
