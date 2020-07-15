package basics.objectDemo.day07_structures.Stack;

/**
 * Created by sulong on 2019/7/15.
 */
public interface Stack<T> {
    boolean isEmpty();

    /**
     * 入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素 未出栈
     * @return
     */
    T peek();

    /**
     * 出栈 并移除
     * @return
     */
    T pop();

}
