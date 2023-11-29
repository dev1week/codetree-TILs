import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int[] dp; // dp[i]=i번째 노드의 자식 수 
    static int[] arr; // 초기값 (전부 0) 
    static boolean[] isVisited;
    
    static List<Integer>[] graph;
    
    static int n; 
    static int r;
    static int q; 
    
    static void init() throws IOException{
    	
    	tokens = new StringTokenizer(buffer.readLine()); 
    	
    	n = Integer.valueOf(tokens.nextToken());
    	r = Integer.valueOf(tokens.nextToken());
    	q = Integer.valueOf(tokens.nextToken());
    	
    	graph = new ArrayList[n+1];
    	
    	for(int node=0; node<=n; node++) {
    		graph[node] = new ArrayList<>();
    	}
    	
    	for(int i=0; i<n-1; i++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		int node1 = Integer.valueOf(tokens.nextToken());
    		int node2 = Integer.valueOf(tokens.nextToken());
    		graph[node1].add(node2);
    		graph[node2].add(node1);
    	}
    	
    }
    
    public static void main(String[] args)throws IOException{
    	init();
    	
    	
    	makeTreeDp(); 
    	
    	StringBuilder result = new StringBuilder(); 
    	for(int query=0; query<q; query++) {
    		int queryNode = Integer.valueOf(buffer.readLine());
    		
    		result.append(dp[queryNode]).append("\n");
    	}
    	
    	System.out.println(result);
    }

	private static void makeTreeDp() {
		
		
		dp = new int[n+1];
		isVisited = new boolean[n+1];
		
		isVisited[r] = true;
		dfs(r); 
		
	}
	
	static void dfs(int x) {
		dp[x] = 1;
		for(int i=0; i<graph[x].size(); i++) {
			int child = graph[x].get(i);
			if(isVisited[child]) continue;
			isVisited[child] = true;
			dfs(child);
			dp[x]+=dp[child];
		}
		
		
		
	}
}