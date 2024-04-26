package Main;
import Main.MyList;
import Main.MyNode;


public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
        }
        else {
            MyNode<T> currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyNode<T> prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);

        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(item);
    }

    @Override
    public void addFirst(T item) {
        add(item,0);
    }

    @Override
    public void addLast(T item) {
        add(item,size-1);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        if (index == 0)
            return currentNode.data;
        else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size-1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.getNext();
        } else {
            MyNode<T> prevNode = getNode(index - 1);
            MyNode<T> currentNode = prevNode.getNext();

            prevNode.setNext(currentNode.getNext());
        }
        size--;

    }
    private MyNode<T> getNode(int index) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {
        boolean swapped;
        MyNode<T> current;
        MyNode<T> next = null;

        do {
            swapped = false;
            current = head;

            while (current.getNext() != next) {
                if (current.getData().compareTo(current.getNext().getData()) > 0) {
                    T temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
            next = current;
        } while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public int LastIndexOf(Object object) {
        MyNode<T> currentNode = head;
        int lastIndex = 0;
        int currentIndex = 0;

        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                lastIndex = currentIndex;
            }
            currentNode = currentNode.getNext();
        }

        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            array[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size ;
    }
    private void PrintArr(Object[] arr){
        System.out.print("{");
        for (int i = 0;i<size-1;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[size-1]);
        System.out.println("}");
    }
    public void PrintLinkedList(){
        Object[] arr = toArray();
        PrintArr(arr);
    }
}