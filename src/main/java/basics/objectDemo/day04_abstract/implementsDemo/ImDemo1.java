package basics.objectDemo.day04_abstract.implementsDemo;

/**
 *
 * Created by sulong on 2019/4/9.
 */
public class ImDemo1 implements ImDemo {
    @Override
    public void eat() {
        System.out.println("吃");
    }

    @Override
    public void sleep() {
        System.out.println("睡");

    }
}
