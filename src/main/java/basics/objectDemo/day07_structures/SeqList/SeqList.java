package basics.objectDemo.day07_structures.SeqList;

import basics.objectDemo.day07_structures.ISeqList;

/**
 * 顺序表底层存储是利用数组实现的
 * 数组可以存储相同数据类型的元素集合
 * 数组是一块连续的内存块 (每个元素的存储地址也是连续的)
 * <p>
 * Created by sulong on 2019/7/10.
 */
public class SeqList<T> implements ISeqList<T> {
    /**
     * 数组声明 用于存储元素
     */
    private Object[] table;
    /**
     * 顺序表大小
     */
    private int length;

    /**
     * 根据声明大小 构造顺序表
     *
     * @param capacity
     */
    public SeqList(int capacity) {
        //申请数组存储空间,元素初始化为null
        this.table = new Object[Math.abs(capacity)];
        this.length = 0;
    }

    /**
     * 默认大小为64
     */
    public SeqList() {
        this(64);
    }

    /**
     * 传入数组 初始化顺序表
     *
     * @param array
     */
    public SeqList(T[] array) {
        if (array == null) {
            throw new NullPointerException("array can\'t be empty");
        }
        this.table = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            this.table[i] = array[i];
        }
        this.length = array.length;
    }


    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }


    @Override
    public int length() {
        return this.length();
    }

    /**
     * 获取元素
     *
     * @param index 不超过数组长this.length()
     * @return
     */
    @Override
    public T get(int index) {
        if (index < this.length() && index >= 0) {
            return (T) this.table[index];
        }
        return null;
    }

    /**
     * 替换某位置元素
     *
     * @param index
     * @param data
     * @return
     */
    @Override
    public T set(int index, Object data) {
        if (index < this.length() && index >= 0 && data != null) {
            T old = (T) this.table[index];
            this.table[index] = data;
            return old;
        }
        return null;
    }

    /**
     * 根据index插入元素
     *
     * @param index index 插入位置的下标,0作为起始值
     * @param data  data 插入的数据
     * @return
     */
    @Override
    public boolean add(int index, Object data) {
        if (data == null) return false;
        //根据下标判断 是否插入在最前面
        if (index < 0) index = 0;
        // 根据下标判断 是否插入在最后面
        if (index < this.length) index = this.length;
        // 判断内部数组是否已满
        if (this.length == table.length) {
            //
            Object[] temp = this.table;
            // 成倍扩展
            this.table = new Object[temp.length * 2];
            //将原来的数组复制到新数组 先复制到插入位置的前一个位置
            // i< index
            for (int i = 0; i < index; i++) {
                this.table[i] = temp[i];
            }
        }
        //①将原数组另一半元素放入新数组 直到index位置 最终腾出来的位置就是新插入元素的位置
        //②将原数组从index位置 都向后调整一个位置 放入index位置元素data
        for (int j = this.length - 1; j >= index; j--) {
            //
            this.table[j + 1] = this.table[j];
        }
        //插入新值
        this.table[index] = data;
        this.length++;
        return true;
    }

    /**
     * 在尾部插入元素
     *
     * @param data
     * @return
     */
    @Override
    public boolean add(Object data) {
        return add(this.length, data);
    }

    /**
     * [0,1,2,3]  0,1,2,3
     * [0,2,3]    0,1,2
     * 移除指定位置元素
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        if (this.length != 0 && index >= 0 && index <= this.length) {
            // 记录删除的元素 并返回
            T da = (T) this.table[index];
            // 从删除的元素位置开始 其后的元素都想前移动
            // 删除第二个元素 第三元素变成了第二个元素
            //
            for (int i = index; i < this.length - 1; i++) {
                this.table[i] = this.table[i + 1];
                // 当删除元素位置 后的元素都向前移动后 数组的最后的一个元素变为空
                this.table[length - 1] = null;
                this.length--;
                return da;
            }
        }
        return null;
    }

    /**
     * 根据data删除元素
     *
     * @param data
     * @return
     */
    @Override
    public boolean remove(Object data) {
        if (this.length != 0 && data != null) {
            return this.remove(this.indexOf(data)) != null;
        }
        return false;
    }

    /**
     * 清空顺序表
     */
    @Override
    public void clear() {
        this.length = 0;

    }

    /**
     * 查询是否包含某个元素
     * @param data
     * @return
     */
    @Override
    public boolean contains(Object data) {
        return this.indexOf(data)>=0;
    }

    /**
     * 根据元素值查找位置
     * @param data
     * @return
     */
    @Override
    public int indexOf(Object data) {
        if (data!=null){
            for (int i =0;i<this.length;i++){
                if (this.table[i].equals(data)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据data查询 最后一个出现在顺序表的下标
     * 倒序查找
     * @param data
     * @return
     */
    @Override
    public int lastIndexOf(Object data) {
        if (data!=null){
            for (int i =this.length-1;i>=0;i--){
                if (data.equals(this.table[i])){
                    return i;
                }
            }
        }
        return -1;
    }
}
