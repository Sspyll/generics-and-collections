package main.java.com.collectionandmap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private static int DEFAULT_CAPACITY = 16;
    public Entry<K, V>[] bucket = new Entry[DEFAULT_CAPACITY];
    private int size = 0;

    public V put(K key, V value) {
        // Check if bucket has enough capacity
        if (size == bucket.length) {
            int newLength = (int) (bucket.length * 1.75);
            bucket = Arrays.copyOf(bucket, newLength);
        }

        int index = getBucketIndex(key);

        Entry<K, V> entry = new Entry<>(key, value);

        // Add entry if this bucket[index] is empty
        if (bucket[index] == null) {
            bucket[index] = entry;
            size++;
            return null;
        }

        // Change value and return old value if this key already exists
        if (containsKey(key)) {
            // Go through entries and check if keys are equal
            while (!(bucket[index].key.equals(key))) {
                bucket[index] = bucket[index].next;
            }
            V oldValue = bucket[index].value;
            bucket[index] = entry;
            return oldValue;
        }

        // Add entry to the end of entries
        while (bucket[index].next != null) {
            bucket[index] = bucket[index].next;
        }
        bucket[index].next = entry;
        size++;
        return null;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % bucket.length);
    }

    boolean containsKey(K key) {
        if (size == 0) {
            return false;
        }

        int index = getBucketIndex(key);
        if (bucket[index] == null) {
            return false;
        }

        Entry<K, V> current = bucket[index];

        while (current.next != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        if (current.key.equals(key)) {
            return true;
        }

        return false;
    }

    public V remove(K key) {
        // Check if key exists
        if (!containsKey(key)) {
            return null;
        }

        V returnValue;
        int index = getBucketIndex(key);

        // Remove if it's a single entry in bucket[index]
        if (bucket[index].next == null) {
            returnValue = bucket[index].value;
            bucket[index] = null;
        } else {
            // Remove if bucket[index] has multiple entries
            while (bucket[index].next.key != key) {
                bucket[index] = bucket[index].next;
            }
            returnValue = bucket[index].next.value;
            bucket[index].next = bucket[index].next.next;
        }

        size--;
        return returnValue;
    }

    public void clear() {
        bucket = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        // Check if key exists
        if (!containsKey(key)) {
            return null;
        }

        int index = getBucketIndex(key);

        // Return value if bucket[index] has a single entry
        if (bucket[index].next == null && bucket[index].key == key) {
            return bucket[index].value;
        }

        // Return value if bucket[index] has multiple entries
        while (bucket[index].key != key) {
            bucket[index] = bucket[index].next;
        }
        return bucket[index].value;
    }

    private static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            hash = key.hashCode();
        }
    }
}
