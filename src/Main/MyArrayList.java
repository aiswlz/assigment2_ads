package Main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = element;
    }

    public void add(T element, int index) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        checkIndex(index);
        size++;
        for (int i = index; i < size; i++) {
            T temp = arr[index];
            arr[index] = element;
            element = temp;
        }
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void PrintArr() {
        System.out.print("{");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[size - 1]);
        System.out.println("}");
    }

    @Override
    public void set(int index, T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        checkIndex(index);
        arr[index] = item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public void addFirst(T item) {
        add(item, 0);
    }

    @Override
    public void addLast(T item) {
        add(item, size - 1);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(arr.length - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        throw new NoSuchElementException("Element not found");
    }

    @Override
    public int LastIndexOf(Object object) {
        for (int i = size - 1; i > 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        throw new NoSuchElementException("Element not found");
    }

    @Override
    public boolean exists(Object object) {
        if (object == null) {
            throw new NullPointerException("Search object cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    @Override
    public void clear() {
        arr = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }


}
