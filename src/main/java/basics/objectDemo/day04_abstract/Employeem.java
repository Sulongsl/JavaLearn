package basics.objectDemo.day04_abstract;

import basics.objectDemo.day03_OverrideAndOverload.Animal;

/**
 * 抽象类
 * 不可被实例化
 * Created by sulong on 2019/4/8.
 */
abstract class Employeem extends Animal{
    private String name;
    private int number;
    private String address;

    /**
     * 接口中的方法被默认指定为  public abstract
     * @return
     */
    public abstract double macPany();

    @Override
    public void move() {
        System.out.println("接口支持继承与重写");
    }

}

