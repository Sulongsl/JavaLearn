package basics.objectDemo.day07_structures;

/**
 *  顺序表顶级接口
 * Created by sulong on 2019/7/10.
 */
public interface ISeqList<T> {
    /**
     * 判断为空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回数组大小
     * @return
     */
    int length();

    /**
     * 获取下标位置元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 在指定位置插入元素
     * @param index
     * @param data
     * @return
     */
    T set(int index,T data);

    /**
     *
     * @param index
     * @param data
     * @return
     */
    boolean add(int index,T data);

    /**
     * 在顺序表末尾添加元素
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     * 删除指定位置元素
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 根据data删除指定元素
     * @param data
     * @return
     */
    boolean remove(T data);

    /**
     *
     */
    void clear();

    /**
     * 是否包含元素
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 查看元素下标
     * @param data
     * @return
     */
    int indexOf(T data);

    /**
     * 根据data值 查询最后一个出现在顺序表中的下标
     * @param data
     * @return
     */
    int lastIndexOf(T data);

    /**
     * 输出格式
     * @return
     */
    String toString();


}
