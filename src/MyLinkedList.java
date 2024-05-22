import java.util.Objects;

public class MyLinkedList<T> {
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

    public void remove(int index) {
        Objects.checkIndex(index, size);

        Node<T> current = head;
        if (index < size * 0.5) {

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = current.next;
            head.previous = null;
        } else if (index == size - 1) {
            tail = current.previous;
            tail.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size -= 1;
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

    public T get(int index) {
        Objects.checkIndex(index, size);

        if (index <= size * 0.5) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        Node<T> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.previous;
        }
        return current.value;
    }

    public int size() {
        return size;
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
