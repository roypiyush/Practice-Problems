package com.personal.list;

class LinkedList {
    @SuppressWarnings("unused")
    private int value;
    private LinkedList next;

    public void add(int value) {

        LinkedList next = new LinkedList();
        next.value = value;

        LinkedList list = this;
        while (list.next != null) {
            list = list.next;
        }
        list.next = next;
    }

    public int calculateLengthIteratively() {
        LinkedList list = this;

        int length = 0;
        while (list != null) {
            list = list.next;
            length++;
        }

        return length;
    }

    public int calculateLengthRecursively(LinkedList list) {
        if (list == null)
            return 0;

        return 1 + calculateLengthRecursively(list.next);
    }

}

public class SimpleLinkedList {


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);

        System.out.println("Iterative Length Calculation : " + linkedList.calculateLengthIteratively());
        System.out.println("Recursive Length Calculation : " + linkedList.calculateLengthRecursively(linkedList));


    }

}
