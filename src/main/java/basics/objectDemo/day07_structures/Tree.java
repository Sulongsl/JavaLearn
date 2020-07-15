package basics.objectDemo.day07_structures;


import basics.objectDemo.day07_structures.ITree.BinaryNode;

/**
 * 树 的顶层接口
 *  Blog : http://blog.csdn.net/javazejian
 * Created by sulong on 2019/7/24.
 */
public interface Tree<T extends Comparable> {

    boolean isEmpty();

    /**
     * 结点总数
     * @return
     */
    int size();

    /**
     * 高度 (深度)
     * @return
     */
    int height();

    /**
     * 先根次序遍历
     * @return
     */
    String preOrder();
    /**
     * 中根次序遍历
     */
    String inOrder();
    /**
     * 后根次序遍历
     */
    String postOrder();
    /**
     * 层次遍历
     */
    String levelOrder();

    /**
     *
     * @param data
     */
    void insert(T data);


    void remove(T data);

    /**
     * 查找最大值
     * @return
     */
    T findMin();

    /**
     * 查找最小值
     * @return
     */
    T findMax();

    /**
     * 根据值 找到结点
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * 判断是否含有某值
     * @param data
     * @return
     * @throws Exception
     */
    boolean contains(T data) throws Exception;


    void clear();

}
