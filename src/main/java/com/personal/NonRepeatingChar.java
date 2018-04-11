/**
 *
 */
package com.personal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author piyush
 */


class LinkedList {

    Node[] nodes = new Node[256];
    boolean[] isRemoved = new boolean[256];
    Node head = null;
    Node tail = null;

    void add(int chr) {

        if (nodes[chr] == null) {
            Node n = new Node(chr);

            if (head == null) {
                head = n;
            } else {
                n.prev = tail;
                tail.next = n;
            }
            tail = n;

            nodes[chr] = n;
            return;
        }

        if (isRemoved[chr]) {
            return;
        }

        // Search for Node in the list and remove it
        Node n = nodes[chr];
        Node prev = n.prev;
        Node next = n.next;
        n.prev = null;
        n.next = null;

        if (n == head && n == tail) {
            head = null;
            tail = null;
        } else if (n == head) {
            head = next;
            head.prev = null;
        } else if (n == tail) {
            tail = prev;
            tail.next = null;
        } else {
            // General case
            prev.next = next;
            next.prev = prev;
        }
        isRemoved[chr] = true;
    }

    int getNonRepeatingCharacter() {
        if (head == null)
            throw new RuntimeException("All character appeared. No more unique characters left");
        return head.character;
    }

    private class Node {
        int character;
        Node next = null;
        Node prev = null;

        Node(int c) {
            character = c;
        }
    }
}

public class NonRepeatingChar {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        LinkedList list = new LinkedList();
        Set<Integer> integers = new HashSet<>();
        while (true) {
            Random r = new Random();
            int rand = r.nextInt(256);

            list.add(rand);
            int nonRepeatingCharacter = list.getNonRepeatingCharacter();
            integers.add(rand);
            System.out.println("Size: " + integers.size() + " Non repeating character: " + nonRepeatingCharacter);
        }

    }

}
