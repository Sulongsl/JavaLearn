package basics.objectDemo.day07_structures.IArrayList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * ArrayList
 *
 * Created by sulong on 2019/7/17.
 */
public class MyArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683452581122892189L;

    // 要分配的数组的最大大小
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    /**
     * Default initial capacity.
     * 默认数组大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 用于空实例的共享空数组实例
     * <p>
     * 空的对象数据
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 默认空的对象数据
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存储数据的数组
     */
    transient Object[] elementData;

    /**
     * ArrayList 元素数量
     *
     * @serial
     */
    private int size;

    /**
     * 无参构造方法使用 另一个数组
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 传入大小参数
     *
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            //当传入参数为0时 使用 EMPTY_ELEMENTDATA
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Capacity " + initialCapacity);
        }

    }

    /**
     * 扩容方法 (将当前数组扩展指定长度的大小)
     * 在扩容前 数组如果是长名字的数组 则会认为这个数组的最小容量为10
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        // 判断需要扩容的数组是否为空数组
        // 如果不为空则变量等于0
        // 为空(0)则变量等于数组默认容量(10)
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;
        //判断是否需要扩容 即想要扩容的容量是否大于 10
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    /**
     * 记录list改动次数 校验参数是否合理
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        // 记录整个list改动的次数
        modCount++;
        // 需要扩容的量大于原数组的长度，则进一步调用方法
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 扩充数组的容量 (真正扩容的地方)
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // 原数组的大小
        int oldCapacity = elementData.length;
        // 原数组长度+原数组长度/2  1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        // 原数组1.5倍 小于 传入扩容大小 则 扩容到 传入大小长度
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //扩容大小超过 类中限定最大限制 则扩容到int类最大长度
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        // 扩容 调用数组扩容方法
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


    /**
     * 鉴别长度是否超出最大容量 并返回 Int 保证数组能正常扩容
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        // 如若需要扩容的量大于了最大限制，则扩容量改为 int 最大限制量：2147483647。否则为本类中所限制长度：2147483647-8
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }


    /**
     * 扩容方法外部封装
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity){
        // 判断如果当前arrayList为
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        ensureCapacity(minCapacity);


    }
    /**
     *
     */
    @Override
    public boolean add(E e){
        // 扩展数组
        ensureCapacityInternal(size+1);
        elementData[size++] = e;
        return true;
    }


    /**
     * 在指定位置添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index,E element){
        // 判断长度是否合理
//        rangeCheckForAdd(index);
        //对数组的容量进行调整
        ensureCapacityInternal(size + 1);
        //整体后移一位，效率不太好啊
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;

    }

    /**
     * 添加一个集合
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        Object[] a = c.toArray();
        int numNew = a.length;
        //拓展容量
        ensureCapacity(numNew+size);
        //逐个后移
        System.arraycopy(a,0,elementData,size,numNew);
        size+=numNew;
//        新数组有元素，就返回 true
        return numNew!=0;
    }


    /**
     * 在指定位置 添加集合
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index ,Collection<? extends E> c){
//        rangeCheckForAdd(index);
        Object[]a =c.toArray();
        int numNew = a.length;
        ensureCapacity(size+numNew);

        int numMoved = size-index;
        if (numMoved>0){
            // y
            System.arraycopy(elementData,index,elementData,index+numNew,numMoved);
        }
        // 将新的数组 添加至指定位置
        System.arraycopy(a,0,elementData,index,numNew);
        size+=numNew;
        return numNew!=0;

    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }
}
