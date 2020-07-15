package basics.objectDemo.day07_structures.ITree.bstAVL;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * AVLMap迭代器 用栈实现
 * Created by sulong on 2019/7/31.
 */
public class AVLIterator<K,V> implements Iterator<AVLEntry<K,V>>{


    private Stack<AVLEntry<K,V>> stack;

    public AVLIterator(AVLEntry<K,V> root){
        stack = new Stack<AVLEntry<K,V>>();
        addLeftPath(root);

    }

    /**
     * 将结点左子树依次入栈
     * @param p
     */
    private void addLeftPath(AVLEntry<K,V> p){
        while (p!=null){
            stack.push(p);
            p=p.left;
        }

    }

    @Override
    public boolean hasNext() {
        return stack.isEmpty();
    }


    @Override
    public AVLEntry<K, V> next() {
        // 出栈
        AVLEntry<K,V> p = stack.pop();
        addLeftPath(p.right);
        return p;

    }

    @Override
    public void remove() {
        throw new ConcurrentModificationException("can not remove!");
    }

    @Override
    public void forEachRemaining(Consumer<? super AVLEntry<K, V>> action) {
    }
}
