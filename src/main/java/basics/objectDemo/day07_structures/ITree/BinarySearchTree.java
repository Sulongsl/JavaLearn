package basics.objectDemo.day07_structures.ITree;

import basics.objectDemo.day07_structures.Tree;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉查找树构造
 * 特性:  对于树种的每个结点T（T可能是父结点）,它的左子树中所有项的值小T中的值，而它的右子树中所有项的值都大于T中的值
 * Created by sulong on 2019/7/24.
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {
    /**
     * 根结点
     */
    protected BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            //对比汉诺塔:H(n)=H(n-1) + 1 + H(n-1)
            return size(p.left) + 1 + size(p.right);
        }
    }

    /**
     * 计算深度 递归
     *
     * @return
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * 递归实现
     *
     * @return
     */
    private int height(BinaryNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            int l = height(p.left);
            int r = height(p.right);
            return (l > r) ? (l + 1) : (r + 1);
        }

    }

    /**
     * 先根遍历
     * 根+ 左子树 + 右子树
     *
     * @return
     */
    @Override
    public String preOrder() {
        String s = preOrder(root);
        if (s.length() > 0) {
            //去掉尾部","号
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /**
     * 先根遍历递归实现
     *
     * @return
     */
    private String preOrder(BinaryNode<T> p) {
        StringBuffer sb = new StringBuffer();
        if (p != null) {
            // 访问根结点
            sb.append(p.data + ",");
            // 遍历左子树
            sb.append(preOrder(p.left));
            //遍历右子树
            sb.append(preOrder(p.right));
        }
        return sb.toString();
    }

    /**
     * 中根遍历
     * 左子树 + 根 + 右子树
     *
     * @return
     */
    @Override
    public String inOrder() {
        String s = inOrder(root);
        if (s.length() > 0) {
            //去掉尾部","号
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /**
     * 递归中根遍历实现
     *
     * @param p
     * @return
     */
    private String inOrder(BinaryNode<T> p) {
        StringBuffer sb = new StringBuffer();
        if (p != null) {
            // 访问左子树
            sb.append(p.left);
            //访问根
            sb.append(p.data + ",");
            //访问右树
            sb.append(p.right);
        }
        return sb.toString();

    }

    /**
     * 后根遍历
     * 左子树  + 右子树+ 根
     *
     * @return
     */
    @Override
    public String postOrder() {
        String s = postOrder(root);
        if (s.length() > 0) {
            //去掉尾部","号
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /**
     * 后根遍历
     * 递归实现
     *
     * @param subtree
     * @return
     */
    public String postOrder(BinaryNode<T> subtree) {
        StringBuffer sb = new StringBuffer();
        //递归结束条件
        if (subtree != null) {
            //先遍历左子树
            sb.append(postOrder(subtree.left));

            //再遍历右子树
            sb.append(postOrder(subtree.right));

            //最后遍历根结点
            sb.append(subtree.data + ",");
        }
        return sb.toString();
    }

    /**
     * 层级遍历
     * 借用队列 先进先出
     * 依次将结点的左右子结点放入
     *
     * @return
     */
    @Override
    public String levelOrder() {
//        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        LinkedBlockingQueue<BinaryNode<T>> queue = new LinkedBlockingQueue<>();
        StringBuffer sb = new StringBuffer();
        BinaryNode<T> p = this.root;

        while (p != null) {
            sb.append(p.data + ",");
            if (p.left != null) {
                sb.append(p.left);
            }
            if (p.right != null) {
                sb.append(p.right);
            }
            // 这里 队列中元素 依次出列 重新定义P 进行while循环
            p = queue.poll();
        }
        return sb.toString();
    }

    /**
     * 直接插入
     *
     * @param data
     */
    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("null");
        }
        // 由根开始查找
        root = insert(data, root);

    }

    /**
     * 插入操作
     * <p>
     * 递归实现()
     * <p>
     * <p>
     * 沿着树查找 比较大小后决定 向左树还是右树 前行
     *
     * @param data
     * @param p
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> p) {
        if (p == null) {
            // p.left 或 p.right为null时 插入同时该插入节点的父节点也被重新定义了。
            p = new BinaryNode<T>(data, null, null);

        }
        // 将要插入的值与根结点数据值比较
        // 指定的数与参数相等返回0  小于返回< -1 大于则返回> 1
        // 参数大于节点数据 返回 1 遍历右子树 小于节点数据 返回-1 遍历左子树 那参数值与节点数据进行比较
        int compareResult = data.compareTo(p.data);
        if (compareResult < 0) {
            //制定了新插入节点的父节点 每次更新
            p.left = insert(data, p.left);
        } else if (compareResult > 0) {
            p.right = insert(data, p.right);
        } else {

        }
        return p;
    }

    /**
     * @param data
     */
    @Override
    public void remove(T data) {
        if (data == null) {
            return;
        }
        root = remove(data, root);

    }

    /**
     * @param data
     * @param p
     * @return
     */
    public BinaryNode<T> remove(T data, BinaryNode<T> p) {
        if (p.left == null && p.right == null) {

        }
        if (p == null) {
            return p;
        }
        // 遍历查询要删除的节点
        int compareResult = data.compareTo(p.data);
        if (compareResult < 0) {
            p.left = remove(data, p.left);
        } else if (compareResult > 0) {
            // 遍历加定义树结构
            p.right = remove(data, p.right);
            // 找到结点后判定结点的子结点个数 2个子结点

            // 找到后传入 remove(data = 6,P = 节点=⑥)

        } else if (p.right != null && p.left != null) {
            // 找到以结点为根 左树中的最小节点
            p.data = findMin(p.right).data;

            p.right = remove(p.data, p.right);
        } else {
            // 只用于一个节点的
            p = (p.left != null) ? p.left : p.right;
        }

        return p;
    }


    /**
     * 根据节点寻找最小data的节点
     *
     * @param p
     * @return
     */
    public BinaryNode<T> findMin(BinaryNode<T> p) {
        if (p == null) {
            return null;
        } else if (p.left == null) {
            return p;
        }
        //递归查找最小
        return findMin(p.left);
    }


    /**
     * 根据节点寻找最大的节点
     *
     * @param p
     * @return
     */
    public BinaryNode<T> findMax(BinaryNode<T> p) {
        if (p == null) {
            return null;
        } else if (p.right == null) {
            return p;
        }
        //递归查找最小
        return findMax(p.right);
    }

    /**
     * @return
     */
    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("null");
        }
        return findMin(root).data;
    }

    /**
     * @return
     */
    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("null");
        }
        return findMax(root).data;
    }

    /**
     * 寻找节点 并返回
     * 比较 data与root的data  compareTo 为 0 时 返回节点
     *
     * @param data
     * @return
     */
    @Override
    public BinaryNode findNode(T data) {
        if (data == null) {
            return null;
        }
        if (data == root.data) {
            return root;
        }
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }


}
