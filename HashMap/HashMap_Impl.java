package Data_Strutures.HashMap;


public class HashMap_Impl<K, V> {

    private class Entry<K, V>{
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value , Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }

    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public HashMap_Impl(){
        this(INITIAL_CAPACITY);
    }

    public HashMap_Impl(int capacity){
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value){
        Entry<K,V> newEntry = new Entry<>(key, value, null);
        int bucketIndex = key.hashCode() % size;

        Entry<K, V> existing = buckets[bucketIndex];
        if(existing == null){
            buckets[bucketIndex] = newEntry;
            size++;
        }else{
            // compare the keys see if key already exists
            while(existing.next != null){
                if(existing.key.equals(key)){
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if(existing.key.equals(key)){
                existing.value = value;
            }else{
                existing.next = newEntry;
                size++;
            }
        }

    }

    public V get(K key){
        Entry<K, V> bucket = buckets[key.hashCode() % size];

        while(bucket != null){
            if(bucket.key.equals(key)){
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public void remove(K key){

        int bucketIndex = key.hashCode() % size;
        Entry previous = null;
        Entry entry = buckets[bucketIndex];

        while(entry != null){
            if(entry.key.equals(key)){
                if(previous == null){
                    entry = entry.next;
                    buckets[bucketIndex] = entry;
                    return;
                }else{
                    previous.next = entry.next;
                }
            }
            previous = entry;
            entry = entry.next;
        }

    }

    public int size(){
        return size;
    }

}
