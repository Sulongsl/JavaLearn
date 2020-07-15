package basics.ioc.iocAndDi;

/**
 * Created by sulong on 2019/4/1.
 */
public class Car {
    private String name;

    public Car(String name){
        this.name = name;
    }

    public void running(){
        System.out.println(this.name + " : To To To");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
