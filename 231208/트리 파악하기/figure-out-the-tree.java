import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class TrieNode{
	TreeMap<String, TrieNode> children;
	
	public TrieNode() {
		children = new TreeMap<>(); 
	}
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
	static List<String>[] words; 
	static TrieNode root; 
	static int n; 
	
	
	static void init() throws IOException{
		n = Integer.valueOf(buffer.readLine());
		
		root = new TrieNode(); 
		
		words = new List[n];
		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(buffer.readLine());
			int wordNum = Integer.valueOf(tokens.nextToken());
			
			List<String> word = new ArrayList<>(); 
			for(int num=0; num<wordNum; num++) {
				word.add(tokens.nextToken());
			}
			
			words[i] = word;
		}
				
		
	}
	
	static StringBuilder result; 
	public static void main(String[] args) throws IOException{
		init(); 
		
		for(int i=0; i<n; i++) {
			insert(words[i]);
		}
		
		result = new StringBuilder(); 
		
		printTree(root, 0);
		
		System.out.println(result);
	}
	
	
	static void insert(List<String> word) {
		TrieNode current = root; 
		
		for(String w : word) {
			if(!current.children.containsKey(w)) {
				current.children.put(w, new TrieNode());
			}
			current = current.children.get(w);
		}
	}
	
	static void printTree(TrieNode current, int depth) {
		
		Set<String> childrenKey = current.children.keySet();
		
		for(String key : childrenKey) {
			
			for(int i=0; i<2*depth; i++) {
				result.append("-");
			}
			result.append(key).append("\n");
			
			printTree(current.children.get(key), depth+1);
		}
		
	}


	
}