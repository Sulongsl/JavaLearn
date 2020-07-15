package basics.objectDemo.day04_abstract;

/**
 * 实现抽象类的子类
 * Created by sulong on 2019/4/8.
 */
public class Salary extends Employeem  {
    private  double salary = 1;
    @Override
    public double macPany() {
        System.out.println("Salary");
        return salary;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(Float.valueOf("15809515380.0").longValue()));
        System.out.println(String.valueOf(Float.valueOf("15809515380").longValue()));
//        String phone = "15809515380.0";
//        System.out.println(String.valueOf(Float.valueOf("15809515380.0").longValue()));
//        System.out.println((phone.substring(0,11)));


//        String s1 = "15809515520";
//        float a =Float.valueOf(s1);
//
//        System.out.println(String.valueOf(a));
//        System.out.println(Long.parseLong(s1));
//        Long.ValueOf("String")返回Long包装类型
//
//        Long.parseLong("String")返回long基本数据类型
//        System.out.println(s1.l());
//
        Salary salary = new Salary();
        salary.macPany();

    }
}
