import java.util.*;
import java.io.*;

class TrieNode{
	TrieNode[] children = new TrieNode[10]; 
	
	boolean isEnd; 
	
	TrieNode() {
		isEnd = false;
		for(int i=0; i<10; i++) {
			children[i] = null;
		}
	}
}
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
	static String[] words; 
	static int n; 
	
	static TrieNode root = new TrieNode();
	public static void insert(String word) {
		TrieNode currentNode = root; 
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i) - '0';
			
			if(currentNode.children[idx]==null) {
				currentNode.children[idx] = new TrieNode();
			}
			
			
			currentNode = currentNode.children[idx];
			
		}
		
		currentNode.isEnd = true;
	}
	
	
	public static boolean isPrefix(String word) {
		TrieNode current = root; 
		
		for(int i=0; i<word.length(); i++) {
			if(current.isEnd) return true; 
			int idx = word.charAt(i)-'0'; 
			current = current.children[idx];
		}
		
		return false;
	}
	
	static void init() throws IOException{
		n = Integer.valueOf(buffer.readLine());
		words = new String[n];

		for(int i=0; i<n; i++) {
			words[i] = buffer.readLine();
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		
		init();
		
		for(String word: words) {
			insert(word);
		}
		
		boolean result = false;
		
		for(String word: words) {
			if(isPrefix(word)) {
				result = true; 
				break; 
			}
		}
		
		
		if(result) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}
		
	}
    
    
    
}