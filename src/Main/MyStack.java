package Main;
import java.util.EmptyStackException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<T>();
    }

    public void push(T item) {
        list.addFirst(item); // Add element to top of the stack
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = list.getFirst(); // Get the top element
        list.removeFirst(); // Remove the top element
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst(); // Get the top element without removing it
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
