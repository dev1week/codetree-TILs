import java.util.*;
import java.io.*;

class TrieNode{
	TrieNode[] children = new TrieNode[26]; 
	
	int count;
	
	TrieNode() {
		count = 0;
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
	
	static long result;
	
	static void init() throws IOException{
		root = new TrieNode();
		n = Integer.valueOf(buffer.readLine());
		result = 0;
		
		tokens = new StringTokenizer(buffer.readLine()); 
		
		for(int i=0; i<n; i++) {
			insert(tokens.nextToken());
		}
		
	}
	
	static void insert(String word) {
		TrieNode current = root; 
		
		for(int i=0; i<word.length(); i++) {
			
			int idx = word.charAt(i)-'a';
			if(current.children[idx]==null) current.children[idx] = new TrieNode();
			
			current = current.children[idx];
			current.count++;
			
		}
	}
	
	static void dfs(TrieNode current, int depth) {
		result = Math.max(result, (long) depth*current.count); 
		
		for(TrieNode child : current.children) {
			if(child!=null) {
				dfs(child, depth+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		
		
		dfs(root, 0);
		
		System.out.println(result);
		
	}
	
	
}