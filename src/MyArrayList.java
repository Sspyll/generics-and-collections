import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
    private Object[] data;
    private static int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Object value) {
        if (size >= data.length) {
            int newLength = data.length + (data.length >> 1);
            data = Arrays.copyOf(data, newLength);
        }
        data[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size -= 1;
    }

    public void clear() {
        data = new Object[0];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }
}
