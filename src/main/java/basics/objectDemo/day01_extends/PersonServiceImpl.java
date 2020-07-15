package basics.objectDemo.day01_extends;

import basics.ioc.iocAndDi.Car;

/**
 *
 * Created by sulong on 2019/4/2.
 */
public class PersonServiceImpl extends Person implements PersonService {
    /**
     * @Override 重写
     * @param car
     */
    // 这个标签用来检查是否正确的重写了父类的方法
    @Override
    public void runCar(Car car) {
        System.out.println("正在开" + car.getName());
    }

    @Override
    public String talking(String talk) {
        return talk;
    }

    /**
     * 这里重写了父类Person的方法
     * @return
     */
    @Override
    public void eating(){
        System.out.println("吃饭中——————子类");
    }
}
