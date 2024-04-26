package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        System.out.println("Value of index 3: " + myLinkedList.get(3));
        System.out.println("Size of an list: " + myLinkedList.size());
        System.out.println("Vaule of index 0 before remove: " + myLinkedList.get(0));
        myLinkedList.remove(0);
        System.out.println("Vaule of index 0 after remove: " + myLinkedList.get(0));
        System.out.println("Size of an list: " + myLinkedList.size());
        System.out.println("Vaule of index 2 before remove: " + myLinkedList.get(2));
        myLinkedList.remove(2);
        System.out.println("Vaule of index 2 after remove: " + myLinkedList.get(2));
        System.out.println("Size of an list: " + myLinkedList.size());

    }
}