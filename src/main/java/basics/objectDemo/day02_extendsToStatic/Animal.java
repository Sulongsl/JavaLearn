package basics.objectDemo.day02_extendsToStatic;

/**
 * 关于继承相关的问题
 * 构造器
 * Created by sulong on 2019/4/3.
 */
public class Animal  {
    private String name;
    private int id;
    public Animal(String myName,int myId){
        name=myName;
        id=myId;
    }
    public void eat(){
        System.out.println(name +"正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction(){
        
    }
}
