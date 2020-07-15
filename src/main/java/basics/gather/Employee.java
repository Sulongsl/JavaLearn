package basics.gather;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 构造方法
 * 静态常量
 * 静态方法
 * Created by sulong on 2019/1/22.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    /**
     * 构造器与类同名 在构造对象时 构造器会运行
     * @param n
     * @param s
     * @param year
     * @param month
     * @param day
     */
    public Employee(String n,double s,int year,int month,int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }

    /**
     * 访问器方法
     * @return
     */
    public Date getHireDay(){
        return hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
