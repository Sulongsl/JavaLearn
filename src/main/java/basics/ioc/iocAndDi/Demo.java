package basics.ioc.iocAndDi;

/**
 * Created by sulong on 2019/3/27.
 */
public class Demo {
    public static void main(String[] args) {
        Car car = new Car("凯迪");
        Person person = new Person(car);
        person.runCar();
    }
}
