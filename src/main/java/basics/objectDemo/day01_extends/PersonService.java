package basics.objectDemo.day01_extends;

import basics.ioc.iocAndDi.Car;

/**
 * Created by sulong on 2019/4/2.
 */
public interface PersonService {
    /**
     * 开车
     * @param car
     */
    void runCar(Car car);

    /**
     * 说话
     * @param talk
     * @return
     */
    String talking(String talk);
}
