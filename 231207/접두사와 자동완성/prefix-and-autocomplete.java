import java.util.*;
import java.io.*;

class TrieNode{
	TrieNode[] children = new TrieNode[26]; 
	
	int count;
	boolean isEnd;
	
	TrieNode() {
		count = 0;
		isEnd = false;
		for(int i=0; i<10; i++) {
			children[i] = null;
		}
	}
}
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
	static int n; 
	
	static TrieNode root;
	
	static String[] words;
	static StringBuilder result; 
	
	static void init() throws IOException{
		n = Integer.valueOf(buffer.readLine());
		root = new TrieNode();
		
		tokens = new StringTokenizer(buffer.readLine());
		
		words = new String[n];
		
		for(int i=0; i<n; i++) {
			words[i] = tokens.nextToken();
		}
		
	}
	
	static void insert(String word) {
		
		TrieNode current = root;
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i)-'a';
			
			if(current.children[idx]==null) {
				current.children[idx] = new TrieNode();
				current.count ++; 
				
			}
			current = current.children[idx];
		}
		current.isEnd = true;
		
	}
	
	static int search(String word) {
		int result = 0;
		TrieNode current = root; 
		
		for(int i=0;i<word.length(); i++) {
			if(current==root||current.count>=2||current.isEnd) {
				result++;
			}
			
			int idx = word.charAt(i) -'a';
			
			if(current.children[idx]!=null) {
				current= current.children[idx];
			}
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args)throws IOException{
		init(); 
		
		
		for(String word : words) {
			insert(word);
		}
		
		StringBuilder result = new StringBuilder();
		
		for(String word : words) {
			result.append(search(word)+" ");
		}
		System.out.println(result);
	}
	
	
	
}