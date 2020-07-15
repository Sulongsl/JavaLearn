package basics.objectDemo.day06;

/**
 * 递归思维
 * 汉诺塔问题
 * Created by sulong on 2019/7/23.
 */
public class HanoiRecursionDemo {
    /**
     * 输出步骤
     * @param n
     * @param x
     * @param y
     * @param z
     */
    public void hanoi(int n,char x,char y,char z){
        if (n==0){

        }else {
            // 将n-1圆盘移动至z
            hanoi(n-1,x,z,y);
            System.out.println(x+"->"+y);
            hanoi(n-1,z,y,x);
        }

    }


    /**
     *
     * @param n 汉诺塔的层数
     * @param x
     * @param y
     * @param z
     * @return
     */
    public int hanoiCount(int n,char x,char y,char z){
        int count = 0;
        if(n==0){

        }else {
            count+=hanoiCount(n-1,x,y,z);
            count+=1;
            count+=hanoiCount(n-1,x,y,z);
        }
        return count;

    }

    public static void main(String[] args) {
        HanoiRecursionDemo hanoi=new HanoiRecursionDemo();
        System.out.println("moveCount="+hanoi.hanoiCount(6,'A','B','C'));

        hanoi.hanoi(3,'A','B','C');




    }
}
