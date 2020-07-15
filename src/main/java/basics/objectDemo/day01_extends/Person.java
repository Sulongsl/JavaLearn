package basics.objectDemo.day01_extends;

/**
 * 父类的Demo
 * Created by sulong on 2019/4/1.
 */
public class Person {
    private String name;
    private Integer age;
    private String thinking;

    public static String look = "看看";

    /**
     * 用来被重写的方法
     */
    public void eating(){
        System.out.println("吃饭中——————父类");
    }

    public static void looking(){
        System.out.println("looking");
    }


    public static void main(String[] args) {
        /**
         * 关于静态方法的调用
         * 无需构建加载及可调用
         */
        Person person = new Person();
        System.out.println(person.look);
        System.out.println(Person.look);
        person.look = "看看2";
        System.out.println(Person.look);
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThinking() {
        return thinking;
    }

    public void setThinking(String thinking) {
        this.thinking = thinking;
    }
}
