package basics.objectDemo.day03_OverrideAndOverload;

/**
 * 重载是多类之间多态性的一种表现
 * 只有被继承的子类才能重写父类中的方法
 * 参数及返回类型必须相同
 * Created by sulong on 2019/4/4.
 */
public class Dog extends Animal {
    @Override
    public void move(){
        //当需要在子类中调用父类的被重写方法时，要使用super关键字。
        super.move();
        System.out.println("狗会跳");
    }

    public void bark(){
        System.out.println("狗会叫");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.move();
        dog.move();
        dog.bark();
    }
}
