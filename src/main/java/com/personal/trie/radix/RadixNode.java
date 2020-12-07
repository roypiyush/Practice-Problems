package com.personal.trie.radix;

import java.util.List;

public class RadixNode {
    private boolean isPrefix = true;
    private char value;
    private List<RadixNode> children;

    public RadixNode(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public List<RadixNode> getChildren() {
        return children;
    }

    public void setChildren(List<RadixNode> children) {
        this.children = children;
    }

    public boolean isPrefix() {
        return isPrefix;
    }

    public void setPrefix(boolean prefix) {
        isPrefix = prefix;
    }

    @Override
    public String toString() {
        return String.format("%s %s", value, (isPrefix ? "" : "*"));
    }
}
