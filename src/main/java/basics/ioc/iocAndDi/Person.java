package basics.ioc.iocAndDi;

/**
 * Created by sulong on 2019/3/27.
 */
public class Person {
    String name;
    /**
     * 年龄
     */
    Integer age;
    /**
     * 人的车
     */
    Car iCar;

    /**
     * 注入
     *
     * @param car
     */
    public Person(Car car) {
        this.iCar = car;
    }

    /**
     *
     */
    public void runCar() {
        iCar.running();
    }

//    /**
//     * 构造方法
//     * @param name
//     * @param age
//     * @param iCar
//     */
//    public Person(String name,Integer age,ICar iCar){
//        this.name = name;
//        this.age = age;
//        this.iCar = iCar;
//    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getiCar() {
        return iCar;
    }

    public void setiCar(Car iCar) {
        this.iCar = iCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
