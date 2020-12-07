package com.personal.trie.radix;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RadixTree {
    final private RadixNode ROOT = new RadixNode('=');

    private void _add(RadixNode node, String item, int pos) {
        if (pos == item.length()) {
            node.setPrefix(false);
            return;
        }
        List<RadixNode> nodes = node.getChildren();
        if (nodes != null && nodes.stream().anyMatch(p -> p.getValue() == item.charAt(pos))) {
            for (RadixNode n : nodes) {
                if (n.getValue() == item.charAt(pos)) {
                    _add(n, item, pos + 1);
                }
            }
        } else {
            if (nodes == null) {
                nodes = new LinkedList<>();
                node.setChildren(nodes);
            }
            RadixNode newNode = new RadixNode(item.charAt(pos));
            nodes.add(newNode);
            _add(newNode, item, pos + 1);
        }
    }

    public void add(String item) {
        _add(ROOT, item, 0);
    }

    public boolean search(String item) {
        System.out.println(String.format("Searching for [%s]", item));
        List<Character> depth = new LinkedList<>();
        _search(depth, ROOT, item, 0);
        String reduce = depth.stream().map(p -> Character.toString(p)).reduce("", (_1, _2) -> _1 + _2);
        boolean isExists = reduce.equals(item);
        System.out.println(String.format("[%s] is %s", item, (isExists ? "found" : "not found")));
        return isExists;
    }

    private void _search(List<Character> depth, RadixNode node, String item, int pos) {
        if (pos == item.length() && !node.isPrefix()) {
            return;
        }
        List<RadixNode> nodes = node.getChildren();
        if (nodes != null && nodes.stream().anyMatch(p -> p.getValue() == item.charAt(pos))) {
            for (RadixNode n : nodes) {
                if (n.getValue() == item.charAt(pos)) {
                    depth.add(n.getValue());
                    _search(depth, n, item, pos + 1);
                }
            }
        }
    }

    public boolean delete(String item) {
        System.out.println(String.format("Will delete [%s]", item));
        return _delete(ROOT, item, 0);
    }

    private boolean _delete(RadixNode node, String item, int pos) {
        if (pos == item.length() && !node.isPrefix()) {
            node.setPrefix(true);
            return true;
        }
        List<RadixNode> nodes = node.getChildren();
        Iterator<RadixNode> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            RadixNode n = iterator.next();
            if (n.getValue() == item.charAt(pos)) {
                boolean result = _delete(n, item, pos + 1);
                if (result && (n.getChildren() == null || n.getChildren().size() == 0)) {
                    iterator.remove();
                }
                return result;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RadixTree tree = new RadixTree();
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "tes";
        tree.add(test1);
        tree.add(test2);
        tree.add(test3);
        tree.search(test1);
        tree.delete(test1);
        tree.search(test1);
        tree.search(test2);
    }
}
