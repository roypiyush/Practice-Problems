package com.coding.search_contact;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private Map<Character, Node> firstnames;
    private Map<Character, Node> lastnames;

    public Dictionary() {
        firstnames = new HashMap<>();
        lastnames = new HashMap<>();
    }

    public void add(String data) {

        String[] name = data.split(" ");

        String lastFirst = name.length == 2 ? (name[1] + " " + name[0]) : "";

        Node first = firstnames.get(data.charAt(0));
        if (first == null) {
            first = new Node(data.charAt(0));
            firstnames.put(data.charAt(0), first);
        }
        internalAdd(first, 1, data, data.length());

        Node last = null;
        if (!lastFirst.isEmpty()) {
            last = lastnames.get(lastFirst.charAt(0));
            if (last == null) {
                last = new Node(lastFirst.charAt(0));
                lastnames.put(lastFirst.charAt(0), last);
            }
            internalAdd(last, 1, lastFirst, lastFirst.length());
        }

    }

    private void internalAdd(Node node, int i, String data, int size) {

        char character = data.charAt(i);
        Map<Character, Node> children = node.getChildren();
        Node n = children.get(character);

        if (n == null) {
            n = new Node(character);
            children.put(character, n);
        }

        if (i + 1 == size) {
            n.setWord(true);
        } else {
            internalAdd(n, i + 1, data, size);
        }
    }

    public List<String> search(String data) {

        List<String> result = new LinkedList<>();
        List<String> list1 = searchByFirstNames(data);
        List<String> list2 = searchByLastNames(data);

        result.addAll(list1);
        result.addAll(list2);

        return result;
    }


    public List<String> searchByFirstNames(String data) {

        List<String> result = new LinkedList<>();

        char charAt = data.charAt(0);
        boolean isLowerCase = Character.isLowerCase(charAt);
        Node node1 = firstnames.get(charAt);
        Node node2 = firstnames.get(isLowerCase ? (char) (charAt - ' ') : (char) (charAt + ' '));

        if (node1 != null)
            internalSearch(node1.getLetter() + "", node1, data, 1, data.length(), result, false);

        if (node2 != null)
            internalSearch(node2.getLetter() + "", node2, data, 1, data.length(), result, false);

        return result;
    }

    public List<String> searchByLastNames(String data) {

        List<String> result = new LinkedList<>();

        char charAt = data.charAt(0);
        boolean isLowerCase = Character.isLowerCase(charAt);
        Node node1 = lastnames.get(charAt);
        Node node2 = lastnames.get(isLowerCase ? (char) (charAt - ' ') : (char) (charAt + ' '));

        if (node1 != null)
            internalSearch(node1.getLetter() + "", node1, data, 1, data.length(), result, true);

        if (node2 != null)
            internalSearch(node2.getLetter() + "", node2, data, 1, data.length(), result, true);

        return result;
    }


    private void internalSearch(String prefix, Node node, String data, int k, int length, List<String> result, boolean isSearchByLastName) {

        if (node == null) {
            return;
        }

        if (node.isWord() && k == length) {
            if (isSearchByLastName) {
                String[] name = prefix.split(" ");
                result.add((name.length == 2 ? name[1] + " " : "") + name[0]);
            } else
                result.add(prefix);
        }

        Map<Character, Node> children2 = node.getChildren();

        if (children2 == null)
            return;

        if (k == length) {
            // End of data, now we can go with searching words only
            Collection<Node> values = children2.values();
            for (Node n : values) {
                internalSearch(prefix + n.getLetter(), n, data, k, length, result, isSearchByLastName);
            }
        } else {
            char c = data.charAt(k);
            Node node2 = children2.get(c);
            if (node2 != null) // Case of Exact Match
                internalSearch(prefix + node2.getLetter(), node2, data, k + 1, length, result, isSearchByLastName);

            boolean isLowerCase = Character.isLowerCase(c);
            Node node3 = children2.get(isLowerCase ? (char) (c - ' ') : (char) (c + ' '));
            if (node3 != null)
                internalSearch(prefix + node3.getLetter(), node3, data, k + 1, length, result, isSearchByLastName);

        }
    }
}
