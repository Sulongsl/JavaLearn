package basics.thread.threadThorough.tongBuRongQi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 写一个 即写时复制的容器Map
 * Created by sulong on 2019/5/8.
 */
public class CopyOnWriteMap<K,V> implements Map<K,V>,Cloneable {

    private volatile Map<K,V> internalMap;

    public CopyOnWriteMap(){
        internalMap = new HashMap<K,V>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(Object key) {
        return internalMap.get(key);

    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        synchronized (this){
            Map<K,V> newMap=new HashMap<K,V>(internalMap);
            V val = newMap.put(key,value);
            internalMap=newMap;
            return val;
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {


    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
