package basics.objectDemo.day03_OverrideAndOverload.duoTai;

/**
 * 子类
 *  对于面向对象而已，多态分为编译时多态和运行时多态。其中编辑时多态是静态的，主要是指方法的重载，它是根据参数列表的不同来区分不同的函数，通过编辑之后会变成两个不同的函数，
 *  在运行时谈不上多态。而运行时多态是动态的，它是通过动态绑定来实现的，也就是我们所说的多态性。
 *
 * Created by sulong on 2019/4/4.
 */
public class JNC extends Wine{


    /**
     * 这里子类重载了父类的fun1方法
     * 参数列表不同 方法名相同 返回值相同--重载
     * 父类是存在该方法的 向上转型后 父类是不能引用该方法的
     * @param a
     */
    public void fun1(String a){
        System.out.println("JNC_fun1");
        fun2();
    }

    /**
     * 这里子类重写了父类的fun2方法
     */
    @Override
    public void fun2(){
        System.out.println("JNC_fun2");
    }

    /**
     * 重写了父类的fun3
     * 向上转型: 父类引用了子类类型的实例对象 这个父类对象拥有父类与子类的共同属性及方法 但是可以调用子类中重写父类的方法
     */
    @Override
    public void fun3(){
        System.out.println("JNC_fun3");
    }

    public static void main(String[] args) {
        /**
         * 这里 Wine类型的对象指向了JNC的实例 由于继承关系 这个JNC对象向上转型为 Wine
         * 这里 定义了一个指向子类的父类引用类型 能够引用顾磊的共同性外 还可以使用子类强大的功能
         * 如 Wine的fun1方法体中fun2所指向的是子类JNC中的fun2方法
         *
         *
         * 指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性，
         * 而对于子类中存在而父类中不存在的方法，该引用是不能使用的，尽管是重载该方法。
         * 若子类重写了父类中的某些方法，在调用该些方法的时候，必定是使用子类中定义的这些方法（动态连接、动态调用）。
         */
        Wine wine = new JNC();
        wine.fun1();
        /**
         * 向上转型: 父类引用了子类类型的实例对象 这个父类对象拥有父类与子类的共同属性及方法 但是可以调用子类中重写父类的方法
         * Wine wine = new JNC(); 这里的wine自动向上转型为 Wine
         */
        wine.fun3();

    }
}
