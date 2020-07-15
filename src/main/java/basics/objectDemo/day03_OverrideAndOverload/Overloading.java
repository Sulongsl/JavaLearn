package basics.objectDemo.day03_OverrideAndOverload;

/**
 * 重载
 * 方法名字相同 参数必须不同(个数或顺序) 返回类型可相同也可不同
 * Created by sulong on 2019/4/4.
 */
public class Overloading {
    public void test(){
        System.out.println("one");
    }

    public int test(int a){
        System.out.println("two");
        return a;
    }
    public String test(String a){
        System.out.println("three");
        return a;
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.test();
        System.out.println(overloading.test(3));
        System.out.println(overloading.test("a"));
    }
}
