package basics.objectDemo.day07_structures.Stack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;

/**
 * 顺序栈 使用数组实现
 * Created by sulong on 2019/7/15.
 */
public class SeqStack<T> implements Stack<T>, Serializable {

    private static final long serialVersionUID = -5413303117698554397L;

    /**
     * 栈顶指针 -1表示空栈
     */
    private int top = -1;
    /**
     * 默认容量 10
     */
    private int capacity = 10;
    /**
     * 存储元素的数组
     */
    private T[] array;

    /**
     * int 类型 默认值为 0
     */
    private int size;

    public int size() {
        return size;
    }

    /**
     *
     */
    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    /**
     *
     */
    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * 扩容的方法
     *
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity < size)            return;
        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for (int i = 0; i < size; i++)
            array[i] = old[i];
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 入栈
     *
     * @param data
     */
    @Override
    public void push(T data) {
        //判断容量
        if (array.length == size) {
            // 扩容
            ensureCapacity(size*2+1);
        }
        // 改变指针指向
        array[++top] = data;
        size++;
    }

    /**
     * 从栈顶取元素 不移除出栈
     * 直接取 顶部指针 返回(不需要指针top变动)
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    /**
     * 从栈顶(顺序表尾部)删除
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    /**
     * 根据数组下标 交换数组内的两个值
     * @param array
     * @param x 数组下标x
     * @param y 数组下标x
     */
    public static void swap(int[] array,int x,int y){
        if (x< 0 || y <0 ) return;
        if (x>array.length-1 || y >array.length-1) return;
        int xx = array[x];
        int yy = array[y];
        array[x] =yy;
        array[y] =xx;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SeqStack<Integer> s = new SeqStack<>();
        System.out.println(s.size);
        s.push(1);
        System.out.println(s.size);

        int[] a = new int[54];
        for (int i =0;i<a.length;i++){
            a[i] = i;
        }
        System.out.println("****Old");
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);
        Random random = new Random();
        for (int i = a.length-1;i>=0;i--){
            //交换
            // random.nextInt(i) 中 i 必须大于 0
            swap(a,a[i],a[random.nextInt()]);
        }
        System.out.println("****New");
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);

    }
}
