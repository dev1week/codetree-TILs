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
	static int m; 
	static StringBuilder result; 
	
	static String[] words;
	static String query; 
	
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine());
		
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken());
		
		words = new String[n]; 
		
		tokens = new StringTokenizer(buffer.readLine());
		for(int i=0; i<n; i++) {
			words[i] = tokens.nextToken(); 
		}
		
		query = buffer.readLine();
	}
    
    
	
	public static void main(String[] args)throws IOException{
		init(); 
		
		for(String word : words) {
			insert(word);
		}
		
		result = printResult(query);
		System.out.println(result);
	}
	
	static TrieNode root = new TrieNode();
	
	static void insert(String word) {
		TrieNode current = root; 
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i)-'a'; 
			if(current.children[idx]==null) {
				current.children[idx]= new TrieNode(); 
			}
			current = current.children[idx];
			current.count++;
		}
	}
	
	static StringBuilder printResult(String query) {
		
		StringBuilder result = new StringBuilder();
		TrieNode current = root;
		
		for(int i=0; i<query.length(); i++) {
			if(current!=null) {
				int idx = query.charAt(i)-'a';
				current = current.children[idx];
			}
			if(current!=null) {
				result.append(current.count+" ");
			}else {
				result.append("0 ");
			}
		}
		
		return result;
	}
    
}