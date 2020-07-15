package basics.objectDemo.day07_structures.ITree.bstAVL;

import java.util.Map;

/**
 * 二叉查找树Map 节点
 * 可实现插入键值对
 * Created by sulong on 2019/7/30.
 */
public class AVLEntry<K,V> implements Map.Entry<K,V> {
    public K key;
    public V value;
    public AVLEntry<K,V> left;
    public AVLEntry<K,V> right;

    public int height=1;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

    public AVLEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }


    /**
     * 重写
     * @return
     */
    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                ", height=" + height +
                '}';
    }

    public void setKey(K key) {
        this.key = key;
    }

    public AVLEntry<K, V> getLeft() {
        return left;
    }

    public void setLeft(AVLEntry<K, V> left) {
        this.left = left;
    }

    public AVLEntry<K, V> getRight() {
        return right;
    }

    public void setRight(AVLEntry<K, V> right) {
        this.right = right;
    }
}
