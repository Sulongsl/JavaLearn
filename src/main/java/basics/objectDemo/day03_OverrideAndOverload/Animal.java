package basics.objectDemo.day03_OverrideAndOverload;

/**
 * 重写
 * 只有被继承的子类才能重写父类中的方法
 * 参数及返回类型必须相同
 *
 * Created by sulong on 2019/4/4.
 */
public class Animal {
    public void move(){
        System.out.println("动物可以移动");
    }
}
