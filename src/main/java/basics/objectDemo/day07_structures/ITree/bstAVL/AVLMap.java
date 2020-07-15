package basics.objectDemo.day07_structures.ITree.bstAVL;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 字典类AVLMap
 * 类似实现 TreeMap<K,V>
 * Created by sulong on 2019/7/30.
 */
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {
    private int size;
    private AVLEntry<K, V> root;
    /**
     * 比较器
     */
    private Comparator<K> comp;
    // 辅助栈 实现插入调整的非递归算法
    private LinkedList<AVLEntry<K, V>> stack = new LinkedList<AVLEntry<K, V>>();

    private Iterator<AVLEntry<K, V>> iterator;


    /**
     * 获取结点的高度
     *
     * @param p
     * @return
     */
    public int getHeight(AVLEntry<K, V> p) {
        return p == null ? 0 : p.height;
    }

    /**
     * 右旋
     *
     * @param p
     * @return
     */
    private AVLEntry<K, V> rotateRight(AVLEntry<K, V> p) {
        //取得p的左子结点作为新的根
        AVLEntry<K, V> left = p.left;
        // 将p的左节点定义为 left 的右子结点
        p.left = left.right;
        // 将p作为新根结点的右子节点
        left.right = p;
        //重新定义高度 (比较左右子树的高低 取较大值作为该节点的高度)
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        // 新根结点的高度  (因为经过右旋转后 p作为新的根结点的右子结点 所以 p.height = getHeight(leif.right))
        left.height = Math.max(getHeight(left.left), p.height) + 1;
        //返回新的根结点
        return left;
    }

    /**
     * 左旋转
     *
     * @param p
     * @return
     */
    private AVLEntry<K, V> rotateLeft(AVLEntry<K, V> p) {
        AVLEntry<K, V> right = p.right;
        p.right = right.left;
        right.left = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        right.height = Math.max(p.height, getHeight(right.right)) + 1;
        return right;
    }

    /**
     * 先左后右
     *
     * @param p
     * @return
     */
    private AVLEntry<K, V> firstLeftThenRight(AVLEntry<K, V> p) {
        //先将左子树左旋
        p.left = rotateLeft(p.left);
        // 再将p结点 右旋
        p = rotateRight(p);
        return p;
    }

    /**
     * 先右后左 旋转
     *
     * @param p
     * @return
     */
    private AVLEntry<K, V> firstRightThenLeft(AVLEntry<K, V> p) {
        // 将p结点的 右子树 右旋
        p.right = rotateRight(p.right);
        //
        p = rotateLeft(p);
        return p;
    }

    /**
     * 插入后调整树  使得平衡因子符合AVL树性质
     *
     * @param key
     */
    private void fixAfterInsertion(K key) {
        AVLEntry<K, V> p = root;
        while (!stack.isEmpty()) {
            // 弹栈 向上回溯的过程
            p = stack.pop();
            // 计算P的平衡因子
            p.height = Math.max(getHeight(p.left), getHeight(p.right));
            // 计算平衡因子
            int d = getHeight(p.left) - getHeight(p.right);
            if (Math.abs(d) < 1) {
                // 平衡 继续向上回溯
                continue;
            } else {
                // 需要进行旋转
                if (d == 2) {
                    // 被插入元素是 左子树
                    // 分为两种情况
                    // 左子树的左子树 单 右旋转
                    if (compare(key, p.left.key) < 0) {
                        p = rotateRight(p);
                        // 否则进行双旋转 先左后右
                    } else {
                        p = firstLeftThenRight(p);
                    }
                } else {
                    // d = -2
                    if (compare(key, p.right.key) < 0) {
                        p = rotateLeft(p);
                        // 否则进行双旋转 现右后左
                    } else {
                        p = firstRightThenLeft(p);
                    }
                }

                // 检测爷爷节点 设置 根节点
                if (!stack.isEmpty()) {
                    if (compare(key, stack.peek().key) < 0) {
                        stack.peek().left = p;
                    } else {
                        stack.peek().right = p;
                    }
                }
            }

        }
        root = p;
    }

    /**
     * 重写比较方法
     * 当插入键值对时 比较 K key 的大小
     *
     * @param a
     * @param b
     * @return
     */
    @SuppressWarnings("unchecked")
    public int compare(K a, K b) {
        // 若比较器不为空则直接调用
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            // 强转
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap(Comparator<K> comp) {
        this.comp = comp;
    }

    public AVLMap() {
        super();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param key
     * @param value
     * @return V
     */
    public V put(K key, V value) {
        // 当根节点为空时 构建为新的根节点
        if (root == null) {
            //直接插入
            root = new AVLEntry<K, V>(key, value);
            //
            stack.push(root);
            size++;
        } else {
            // 根节点不为空

            AVLEntry<K, V> p = root;
            while (p != null) {
                // 比较key
                stack.push(root);
                int compareResult = compare(key, p.key);
                if (compareResult == 0) {
                    // 当插入相同key时替换value的值 返回
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    // p 无左子树
                    if (p.left == null) {
                        p.left = new AVLEntry<K, V>(key, value);
                        stack.push(root);

                        size++;
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    // p 无右子树
                    if (p.right == null) {
                        p.right = new AVLEntry<K, V>(key, value);
                        stack.push(root);

                        size++;
                        break;
                    } else {
                        //继续循环
                        p = p.right;

                    }
                }
            }

        }
        fixAfterInsertion(key);
        return value;

    }


    /**
     * 自助实现迭代器
     *
     * @return
     */
    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<K, V>(root);
    }

    /**
     * 递归实现 二叉排序查找
     *
     * @param key
     * @return
     */
    public AVLEntry<K, V> getEntry(K key) {
        if (key == null) {
            return null;
        }
        AVLEntry<K, V> p = root;
        return getEntryBy(p, key);
    }

    private AVLEntry<K, V> getEntryBy(AVLEntry<K, V> root, K key) {
        while (root != null) {
            int comperResult = compare(root.key, key);
            if (comperResult == 0) {
                return root;
            } else if (comperResult < 0) {
                getEntryBy(root.right, key);
            } else {
                getEntryBy(root.left, key);
            }
        }
        return null;
    }

    /**
     * @param key
     * @return
     */
    public boolean conraninsKey(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p != null;
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p != null ? p.getValue() : null;
    }


    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> itr = this.iterator;
        while (itr.hasNext()) {
            if (itr.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }


}
