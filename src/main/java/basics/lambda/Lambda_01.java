package basics.lambda;


import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 *
 * 引用值而不是变量
 * @author : Su Long
 * @date : 2019/10/24
 */
public class Lambda_01 {
    // 实现Runnable接口
    Runnable runnable = () -> System.out.println("hello world");

    ActionListener actionListener = event -> System.out.print("hello actionListener");

    Runnable runnable_1 = () -> {
        System.out.println("A");
        System.out.println("B");
    };

    BinaryOperator<Long> add = (x, y) -> x + y;

    public String getName(){
        return "name";
    }


    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello world");
        Thread thread = new Thread(runnable);
        thread.start();






    }


}
