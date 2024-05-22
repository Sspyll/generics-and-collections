import java.util.Objects;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);

        if (index <= size * 0.5) {
            MyQueue.Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        MyQueue.Node<T> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.previous;
        }
        return current.value;
    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current = next;
        }

        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return (T) head.value;
    }

    public T poll() {
        Node<T> current = head;
        head = head.next;
        head.previous = null;
        size -= 1;
        return (T) current.value;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }
}
