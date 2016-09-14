package com.personal.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node {
	
	private Node parent;
	private char c;
	private boolean isWord = false;
	private boolean isUpperCase = false;
	private boolean isLowerCase = false;
	
	private Map<Character, Node> children;
	
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
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public boolean isUpperCase() {
		return isUpperCase;
	}

	public void setUpperCase(boolean isUpperCase) {
		this.isUpperCase = isUpperCase;
	}

	public boolean isLowerCase() {
		return isLowerCase;
	}

	public void setLowerCase(boolean isLowerCase) {
		this.isLowerCase = isLowerCase;
	}

	@Override
	public String toString() {
		return Character.toString(c);
	}
}

class Dictionary {

	private Map<Character, Node> children;
	
	public Dictionary() {
		children = new HashMap<>();
	}
	
	public void add(String data) {
		
		Node node = children.get(data.charAt(0));
		if(node == null) {
			node = new Node(data.charAt(0));
			children.put(data.charAt(0), node);
		}
		
		internalAdd(node, 1, data, data.length());
	}
	
	private void internalAdd(Node node, int i, String data, int size) {
		
		if(i == size)
			return;
		
		char character = data.charAt(i);
		Map<Character, Node> children = node.getChildren();
		if(children == null) {
			children = new HashMap<>();
			node.setChildren(children);
		}
		
		Node n = children.get(character);
		if(n == null) {
			n = new Node(character);
			children.put(character, n);
		}
		
		if(i + 1 == size) {
			n.setWord(true);
		}
		else {
			internalAdd(n, i + 1, data, size);
		}
	}

	public List<String> search(String data) {
		
		List<String> result = new ArrayList<>();
		
		Node node = null;
		
		for(Entry<Character, Node> entry : children.entrySet()) {
			if(entry.getKey() == data.charAt(0))
			node = internalSearch(entry.getValue(), data, 1, data.length());
		}
		
		findWords(data, result, node);
		
		return result;
	}

	private Node internalSearch(Node node, String data, int k, int length) {

		if(k == length || node == null) {
			return node;
		}
		
		
		Node n = null;
		Map<Character, Node> children = node.getChildren();
		Node node2 = children.get(data.charAt(k));
		
		if(node2 == null)
			return node;
		
		n = internalSearch(node2, data, k + 1, data.length());
		
		return n;
	}
	
	private void findWords(String prefix, List<String> result, Node node) {
		
		if(node == null) return;
		
		if(node.isWord()) {
			result.add(prefix); 
		}
		
		
		Map<Character, Node> children = node.getChildren();
		if(children != null)
			for (Entry<Character, Node> entry : children.entrySet()) {
				findWords(prefix + entry.getValue().getLetter(), result, entry.getValue());
			}
		
	}
	
}


public class PhoneBook {

	public static void main(String[] args) {
		
		Dictionary dictionary = new Dictionary();
		dictionary.add("piyush");
		dictionary.add("piyushroy");
		dictionary.add("piyusu");
		System.out.println(dictionary.search("piyush"));
	}

}
