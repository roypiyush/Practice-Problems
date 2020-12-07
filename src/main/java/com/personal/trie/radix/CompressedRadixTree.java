package com.personal.trie.radix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompressedRadixTree {
    private PrefixNode ROOT = new PrefixNode(new char[]{'='});

    /**
     * First pointer where deviation occurs. Zero means no prefix match.
     *
     * @param suffix
     * @param prefix
     * @return position
     */
    private int findDeviationPositionWRTPrefix(String suffix, char[] prefix) {
        int i = 0;
        int prefixSize = prefix.length;
        while (i < prefixSize && prefix[i] == suffix.charAt(i)) {
            i++;
            if (suffix.length() == i) {
                // Prefix matches
                return -1;
            }
        }
        return i;
    }

    private void _add(PrefixNode node, String item, int pos) {
        if (pos == item.length()) {
            return;
        }
        List<PrefixNode> childNodes = node.getChildren();
        if (childNodes == null) {
            childNodes = new LinkedList<>();
            node.setChildren(childNodes);
        }

        PrefixNode childWithPrefix = null;
        int deviationPosition = 0;
        for (PrefixNode child : childNodes) {
            deviationPosition = findDeviationPositionWRTPrefix(item.substring(pos), child.getPrefix());
            if (deviationPosition < 0 || deviationPosition == child.getPrefix().length) {
                return;
            }
            if (deviationPosition > 0) {
                childWithPrefix = child;
                break;
            }
        }
        if (childWithPrefix == null) {
            childNodes.add(new PrefixNode(item.substring(pos).toCharArray()));
        } else {
            if (deviationPosition < childWithPrefix.getPrefix().length) {
                char[] newPrefix = Arrays.copyOfRange(childWithPrefix.getPrefix(), 0, deviationPosition);
                char[] newSuffix = Arrays.copyOfRange(childWithPrefix.getPrefix(), deviationPosition, childWithPrefix.getPrefix().length);
                childWithPrefix.setPrefix(newPrefix);
                List<PrefixNode> childsChildren = childWithPrefix.getChildren();
                PrefixNode prefixNode = new PrefixNode(newSuffix);
                prefixNode.setChildren(childsChildren);

                LinkedList<PrefixNode> s = new LinkedList<>();
                childWithPrefix.setChildren(s);

                s.add(prefixNode);
                s.add(new PrefixNode(item.substring(deviationPosition + pos).toCharArray()));

            } else if (deviationPosition == childWithPrefix.getPrefix().length) {
                _add(childWithPrefix, item, deviationPosition + pos);
            }
        }
    }

    public void add(String item) {
        _add(ROOT, item, 0);
    }

    public boolean search(String item) {
        System.out.println(String.format("Searching for [%s]", item));
        boolean isExists = _search(ROOT, item, 0);
        System.out.println(String.format("[%s] is %s", item, (isExists ? "found" : "not found")));
        return isExists;
    }

    private boolean _search(PrefixNode node, String item, int pos) {
        if (pos == item.length()) {
            return true;
        }
        List<PrefixNode> nodes = node.getChildren();
        if (nodes != null) {
            for (PrefixNode n : nodes) {
                int deviationPosition = findDeviationPositionWRTPrefix(item.substring(pos), n.getPrefix());
                if (deviationPosition < 0) {
                    return true;
                }
                if (deviationPosition > 0) {
                    return _search(n, item, pos + deviationPosition);
                }
            }
        }
        return false;
    }

    public boolean delete(String item) {
        System.out.println(String.format("Will delete [%s]", item));
        return _delete(ROOT, item, 0);
    }

    private boolean _delete(PrefixNode node, String item, int pos) {
        if (node.getChildren() != null) {
            Iterator<PrefixNode> iterator = node.getChildren().iterator();
            while (iterator.hasNext()) {
                PrefixNode n = iterator.next();
                int deviationPosition = findDeviationPositionWRTPrefix(item.substring(pos), n.getPrefix());
                if (deviationPosition < 0) {
                    if (n.getChildren() != null) {
                        // Cannot delete non-leaf nodes
                        return false;
                    }
                    iterator.remove();
                    return true;
                }
                if (deviationPosition > 0) {
                    return _delete(n, item, pos + deviationPosition);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CompressedRadixTree tree = new CompressedRadixTree();
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
