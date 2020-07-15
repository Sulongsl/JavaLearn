package basics.objectDemo.day03_OverrideAndOverload.duoTai.test;

/**
 * 总结来说 找本类中的方法
 *         找父类中的方法
 *         找传入对象的父类作为参数 传入调用 本类方法
 *         找传入对象的父类作为参数 传入调用 本类的父类的方法
 * Created by sulong on 2019/4/4.
 */
public class Test {
    public static void main(String[] args) {
        A a1 = new A();

        /**
         *向上转型 a2中的 show方法开始有变化
         */
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        /**
         * B 为A de子类
         * C D 为 B的子类
         */
        System.out.println("1--" + a1.show(b)); // A A
        System.out.println("2--" + a1.show(c)); // A A
        System.out.println("3--" + a1.show(d)); // A D


        /**
         * a2.show 根据对象传入发生变化 show(B) -> BB  (这里错误!!)
         *                          被子类重写才会调用 这时 a2的show并没有以传入B对象的方法 会认为以A调用的show(A)
         *                          show(A) BA
         *                          show(D) AD
         */
        System.out.println("4--" + a2.show(b)); // B A
        /**
         * a2.show(new C())  第一顺序找本类中的show(C)  A中并没有show(C)
         *                   第二顺序父类的show(C)  A并无父类
         *                   第三顺序找 a2.show(super.show(C)) 也就是找对象C的父类 C的父类是A or B-> a2.show(A or B)
         */
        System.out.println("5--" + a2.show(c)); // B A
        /**
         * 这里从第一步就找到了A类中的show(D)
         */
        System.out.println("6--" + a2.show(d)); // A D

        System.out.println("7--" + b.show(b)); //BB
        /**
         * 这里并没有向上转型  C的父类为B 所以直接走
         */
        System.out.println("8--" + b.show(c)); //BB
        /**
         * 没有向上转型 但由于 B的父类为A 又没有重写 所以存在 show(D)这个方法
         */
        System.out.println("9--" + b.show(d)); //AD
    }
}
