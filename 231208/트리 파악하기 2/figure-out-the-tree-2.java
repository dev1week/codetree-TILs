import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class TrieNode{
	TrieNode[] children = new TrieNode[26]; 
	
	char data;
	boolean isEnd;
	
	
	TrieNode() {
		
		isEnd = false;
		for(int i=0; i<26; i++) {
			children[i] = null;
		}
	}
}
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
	static String[] words; 
	static int n; 
	
	static TrieNode root;
	
	static void init() throws IOException{
		n = Integer.valueOf(buffer.readLine());
		words = new String[n];
		root = new TrieNode();
		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(buffer.readLine());
			int k = Integer.valueOf(tokens.nextToken()); 
			StringBuilder word = new StringBuilder(); 
			for(int j=0; j<k; j++) {
				word.append(tokens.nextToken());
			}
			
			words[i] = word.toString();
			
			insert(word.toString());
		}
		
	}
	
	
	static void insert(String word) {
		TrieNode current = root;
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i)-'A';
			
			if(current.children[idx]==null) {
				current.children[idx] = new TrieNode(); 
			}
			current.data = word.charAt(i);
			current = current.children[idx];
			
		}
		current.isEnd= true;
	}
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws IOException{
		init(); 
		
		printTree(root, 0);
		
		System.out.println(result);
		
	}
	
	static void printTree(TrieNode current, int depth) {
		for(int idx=0; idx<26; idx++) {
			if(current.children[idx]!=null) {
				for(int i=0; i<2*depth; i++) {
					result.append("-");
				}
				char data = (char) (idx +'A');
				
				result.append(data).append("\n");
				printTree(current.children[idx], depth+1);
			}
		}
		
		
	}

	
}