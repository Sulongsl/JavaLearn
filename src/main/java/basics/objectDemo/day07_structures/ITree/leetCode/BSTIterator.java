package basics.objectDemo.day07_structures.ITree.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * 173 二叉搜索迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 * 思路①: 就是中序遍历 构建arraylist 利用中序遍历添加到list然后利用list转迭代器
 * 思路②: 压栈 出栈 按照左璐静依次压栈(有左子节点) 无右子树 弹栈
 *
 * Created by sulong on 2019/7/30.
 */
public class BSTIterator {

    TreeMap<Integer,String> treeMap = new TreeMap<>();

    private Iterator<Integer> itr;

    /**
     *
     * @param root
     */
    public BSTIterator(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        itr=list.iterator();

    }

    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root!=null){
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return itr.next();

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return itr.hasNext();
    }

}


