import java.util.NoSuchElementException;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public void printList(){
        for (int i = 0; i < size(); i++){
            System.out.print(get(i) + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 11; i++){
            list.addLast(i);
        }
        System.out.println("Исходный список");
        list.printList();
        list.reverse();
        System.out.println("Перевернутый список");
        list.printList();
    }
}