import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int root;
    static int n; 
    static int maxNode;
    static List<Integer>[] graph;
    static Set<Integer> nodes;
    static int[] indegree;
    static boolean[] isVisited; 
    static int m; 
    
    
    static void init() throws IOException{
    	n = 10000;
    	m = Integer.valueOf(buffer.readLine());
    	
    	graph = new List[n+1];
    	indegree = new int[n+1];
    	nodes = new HashSet<>();
    	
    	for(int node=0; node<=n; node++) {
    		graph[node] = new ArrayList<>(); 
    	}
    	
    	for(int node=0; node<m; node++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		
    		int start = Integer.valueOf(tokens.nextToken());
    		int end = Integer.valueOf(tokens.nextToken());
    		
    		
    		
    		indegree[end]++;
    		
    		graph[start].add(end);
    		graph[end].add(start);
    		
    		nodes.add(start);
    		nodes.add(end);
    		
    		maxNode = Math.max(start, maxNode);
    		maxNode = Math.max(end, maxNode);
    	}
    		
    }
    
    static boolean isValidTree() {
    	return root!=-1&&isValidEdge()&&isValidRoute();
    }
    
    static boolean isValidRoute() {
    	for(int start:nodes) {
    		isVisited = new boolean[maxNode+1];
    		isVisited[start] = true;
    		dfs(start);
    		
    		if(!isAllVisited(start)) {
    			
    			return false;
    		}
    	}
    	
    	return true; 
    }
    
    static boolean isAllVisited(int start) {
    	for(int node : nodes) {
    		if(start==node) continue;
    		if(!isVisited[node]) {
    			System.out.println(start+"->"+node);
    			return false;
    		}
    	}
    	return true;
    }
    
    static void dfs(int current) {
    	
    	for(int child : graph[current]) {
    		if(!isVisited[child]) {
    			isVisited[child] = true;
    			dfs(child);
    		}
    	}
    }
    
    static void printDfs(int current) {
    	
    	for(int child : graph[current]) {
    		if(!isVisited[child]) {
    			System.out.println(current);
    			isVisited[child] = true;
    			dfs(child);
    		}
    	}
    	
    }
    static boolean isValidEdge() {
    	for(int node: nodes) {
    		if(root==node)continue; 
    		if(indegree[node]!=1) {
    			return false;
    		}
    	}
    	return true;
    }
    
    static int getRoot() {
    	int root = -1;
    	int rootCount = 0;
    	for(int node : nodes) {
    		if(indegree[node]==0) {
    			rootCount++;
    			root = node;
    		}
    	}
    	
    	if(rootCount==1) {
    		return root;
    	}else {
    		return -1;
    	}

    }
    
    public static void main(String[] args)throws IOException{
    	init();
    	
    	root = getRoot();
    	
//    	System.out.println(root);
//    	System.out.println(isValidEdge());
//    	System.out.println(isValidRoute());
    	if(isValidTree()) {
    		System.out.println(1);
    	}else {
    		System.out.println(0);
    	}
    	
    
    	
    }
    
    
}