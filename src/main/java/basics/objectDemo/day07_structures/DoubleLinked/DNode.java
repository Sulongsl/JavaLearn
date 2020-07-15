package basics.objectDemo.day07_structures.DoubleLinked;

/**
 * 双链表节点数据类
 * Created by sulong on 2019/7/12.
 */
public class DNode<T> {
    public T data;
    public DNode<T> prev,next;

    public DNode(T data,DNode<T> prev,DNode<T> next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }

    public DNode(T data){
        this(data,null,null);
    }

    public DNode(){
        this(null,null,null);
    }

    public String toString()
    {
        return this.data.toString();
    }

}
