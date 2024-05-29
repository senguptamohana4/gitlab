package com.assignments;

public class TrieNode {
	
	public Dictionary<char, TrieNode> Children {get; private set;}
	public bool IsEndOfWord {get; set;}
	
	public TrieNode() {
		Children = new Dictionary<char, TrieNode>();
		IsEndOfWord = false;
		
	}

}
public class Trie {
	private readonly TrieNode _root;
	
	public trie() {
		_root = new TrieNode();
	}
	
	public void Insert(string word) {
		var currentNode = _root;
		foreach(var ch in word) {
			if(!currentNode.Children.ContainsKey(ch)) {
				currentNode = currentNode.Children[ch] = new TrieNode();
			}
			currentNode = currentNode.children[ch];
		}
		currentNode.IsEndOfWord = true;
		}
}
public class Program {
	public static void main(String args[]} {
		var trie = new Trie();
		
		trie.Insert("Hello);"
		trie.Insert("heaven");
		trie.Insert("hell);"
			
		System.out.println(trie.startsWith("he"));
		System.out.println(trie.startsWith("hell"));
	}
}
