package basics.objectDemo.day02_extendsToStatic;

/**
 * 子类
 * Created by sulong on 2019/4/4.
 */
public class Bird extends Animal {
    /**
     * 子类是不能继承父类的构造方法的
     * 但是当父类有含参的构造方法时 必须在子类的构造器中通过super关键字调用父类的构造器
     * @param myName
     * @param myId
     */
    public Bird(String myName, int myId) {
        super(myName, myId);
    }
}
