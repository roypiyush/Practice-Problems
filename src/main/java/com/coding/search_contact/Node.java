/**
 *
 */
package com.coding.search_contact;

import java.util.HashMap;
import java.util.Map;


/**
 * Node to represent each hierarchy of characters
 *
 * @author piyush
 */
public class Node {

    private char c;
    private boolean isWord = false;

    private Map<Character, Node> children = new HashMap<>(1);

    public Node(char c) {
        this.c = c;
    }

    public char getLetter() {
        return c;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }

    @Override
    public String toString() {
        return "node=" + Character.toString(c);
    }
}
