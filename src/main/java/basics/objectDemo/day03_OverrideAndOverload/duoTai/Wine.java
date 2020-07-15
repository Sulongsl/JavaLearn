package basics.objectDemo.day03_OverrideAndOverload.duoTai;

/**
 *
 * 封装: 隐藏类的内部实现机制 可以在不影响使用的情况下改变类的内部结构 同时也保护了数据。对外暴露可以自己选择
 * 继承: 重用代码
 * 多态:
 * Created by sulong on 2019/4/4.
 */
public class Wine {
    public void fun1(){
        System.out.println("Wine_fun1");
        fun2();
    }
    public void fun2(){
        System.out.println("Wine_fun2");
    }

    public void fun3(){
        System.out.println("Wine_fun3");
    }
}
