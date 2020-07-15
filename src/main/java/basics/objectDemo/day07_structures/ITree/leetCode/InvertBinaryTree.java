package basics.objectDemo.day07_structures.ITree.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226 翻转二叉树
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * Created by sulong on 2019/7/30.
 */
public class InvertBinaryTree {

    /**
     * 交换一棵树的左右子树节点
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root){
        if (root!=null){
            TreeNode t = root.left;
            root.left=root.right;
            root.right=t;
            // 先序遍历  or 后序  or 中序
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }else {
            return null;
        }

    }

    /**
     * 交换一棵树的左右子树节点
     * 层次遍历
     * @param root
     * @return
     */
    public TreeNode invertTree_bfs(TreeNode root){
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode t = p.left;
            p.left=p.right;
            p.right=t;
            if (p.left!=null){
                queue.offer(p.left);
            }
            if (p.right!=null){
                queue.offer(p.right);
            }

        }
        return root;
    }


}
