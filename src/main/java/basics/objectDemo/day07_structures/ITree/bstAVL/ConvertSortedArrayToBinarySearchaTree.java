//package basics.object.day07_structures.ITree.bstAVL;
//
//import basics.object.day07_structures.ITree.leetCode.TreeNode;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Iterator;
//
///**
// * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
// *
// * 将有序数组构造为AVL树
// * Created by sulong on 2019/7/31.
// */
//
//class LeeCodeAVL{
//    private int size;
//    private TreeNode root;
//
//    public boolean isEntry(){
//        return size==0 ? true:false;
//    }
//
//    /**
//     * @param key
//     */
//    public void put(int key) {
//        // 当根节点为空时 构建为新的根节点
//        if (root == null) {
//            //直接插入
//            root = new TreeNode;
//            size++;
//        } else {
//            // 根节点不为空
//            TreeNode p = root;
//            while (p != null) {
//                // 比较key
//                int compareResult =key-p.val;
//                if (compareResult == 0) {
//                    break;
//                } else if (compareResult < 0) {
//                    // p 无左子树
//                    if (p.left == null) {
//                        p.left = new TreeNode(key);
//                        size++;
//                        break;
//                    } else {
//                        p = p.left;
//                    }
//                } else {
//                    // p 无右子树
//                    if (p.right == null) {
//                        p.right =  new TreeNode(key);
//                        size++;
//                        break;
//                    } else {
//                        //继续循环
//                        p = p.right;
//
//                    }
//                }
//            }
//
//        }
//
//    }
//
//
//    /**
//     * 存储高度
//     */
//    private HashMap<TreeNode,Integer> heightMap = new HashMap<>();
//    public int getHeight(TreeNode p){
//       return heightMap.containsKey(p)?heightMap.get(p):0;
//    }
//
//    /**
//     * 旋转
//     * @param p
//     * @return
//     */
//    private TreeNode rotateRight(TreeNode p){
//        TreeNode left = p.left;
//        p.left=left.right;
//        left.right =p;
//        heightMap.put(p,Math.max(getHeight(p.left),getHeight(p.right)+1));
//        heightMap.put(left,Math.max(getHeight(left.left),getHeight(p.right)+1));
//        return left;
//    }
//
//    /**
//     * 自助实现迭代器
//     *
//     * @return
//     */
//    @Override
//    public Iterator<AVLEntry<K, V>> iterator() {
//        return new AVLIterator<K, V>(root);
//    }
//
//    /**
//     * 递归实现 二叉排序查找
//     *
//     * @param key
//     * @return
//     */
//    public AVLEntry<K, V> getEntry(K key) {
//        if (key == null) {
//            return null;
//        }
//        AVLEntry<K, V> p = root;
//        return getEntryBy(p, key);
//    }
//
//    private AVLEntry<K, V> getEntryBy(AVLEntry<K, V> root, K key) {
//        while (root != null) {
//            int comperResult = compare(root.key, key);
//            if (comperResult == 0) {
//                return root;
//            } else if (comperResult < 0) {
//                getEntryBy(root.right, key);
//            } else {
//                getEntryBy(root.left, key);
//            }
//        }
//        return null;
//    }
//
//
//
//}
//public class ConvertSortedArrayToBinarySearchaTree {
//    public TreeNode sortedArrayToBST_UsingAvl(int[] nums) {
//        return null;
//    }
//}
