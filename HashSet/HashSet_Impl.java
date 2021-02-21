package Data_Strutures.HashSet;

import java.util.HashMap;
import java.util.HashSet;

public class HashSet_Impl<E> {

    HashMap<E , Object> map;

    private static final Object PRESENT = new Object();

    public HashSet_Impl(){
        map = new HashMap<>();
    }

    public HashSet_Impl(int initialCapacity){
        map = new HashMap<>(initialCapacity);
    }

    public HashSet_Impl(int initialCapacity, float loadFactor){
        map = new HashMap<>(initialCapacity , loadFactor);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean contains(E object){
        return map.containsKey(object);
    }

    public boolean add(E element){
        return map.put(element, PRESENT) == null;
    }

    public boolean remove(E element){
        return map.remove(element)==PRESENT;
    }

    public void clear(){
        map.clear();
    }

}
