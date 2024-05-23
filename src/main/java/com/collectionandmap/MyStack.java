package main.java.com.collectionandmap;

import java.util.Arrays;
import java.util.Objects;

public class MyStack {
    private Object[] data;
    private static int DEFAULT_CAPACITY = 10;
    private int size;

    public MyStack() {
        this.data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object push(Object value) {
        if (size == data.length) {
            int newLength = data.length + (data.length >> 1);
            data = Arrays.copyOf(data, newLength);
        }
        data[size] = value;
        size++;
        return value;
    }

    public Object remove(int index) {
        Objects.checkIndex(index, size);

        Object element = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return element;
    }

    public void clear() {
        data = new Object[0];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return data[size - 1];
    }

    public Object pop() {
        Object element = data[size - 1];
        data[size - 1] = null;
        size--;
        return element;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }
}
