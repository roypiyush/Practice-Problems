package com.personal.trie.radix;

import java.util.List;

public class PrefixNode {
    private char[] prefix;
    private List<PrefixNode> children;

    public PrefixNode(char[] prefix) {
        this.prefix = prefix;
    }

    public char[] getPrefix() {
        return prefix;
    }

    public void setPrefix(char[] prefix) {
        this.prefix = prefix;
    }

    public List<PrefixNode> getChildren() {
        return children;
    }

    public void setChildren(List<PrefixNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char c : prefix) {
            builder.append(c);
        }
        return builder.toString();
    }
}
