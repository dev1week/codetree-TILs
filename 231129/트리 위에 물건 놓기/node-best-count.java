import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n; 
    
    static int[][] dp; //dp[i][j] j=0일 경우 물건 없음  서브트리의 물건 총합  
    					// j=1일 경우 물건 있음 
    //초기값 
    	//dp[x][0] = 0;
    	//dp[x][1] = 1;
    
    //점화식 
    	//dp[current][1] = min(dp[child][0], dp[child][1]); 
    	//dp[current][0] = dp[child][1]
    
    static List<Integer>[] graph;
    static boolean[] isVisited; 
    static int[] parents; 
    
    static void init() throws IOException{
    	n = Integer.valueOf(buffer.readLine());
    	
    	graph = new List[n+1];
    	isVisited = new boolean[n+1]; 
    	parents = new int[n+1];
    	
    	for(int node=0; node<=n; node++) {
    		graph[node] = new ArrayList<>();
    	}

    	for(int node=0; node<n-1; node++) {
    		tokens = new StringTokenizer(buffer.readLine()); 
    		
    		int node1 = Integer.valueOf(tokens.nextToken());
    		int node2 = Integer.valueOf(tokens.nextToken()); 
    		
    		graph[node1].add(node2);
    		graph[node2].add(node1);
    		
    	}
    }
    
    public static void main(String[]args) throws IOException{
    	init(); 
    	
    	
    	makeDp();
    	
    	System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    static void makeDp() {
    	
    	dp = new int[n+1][2];
    	isVisited[1] = true;
    	dfs(1);
    }
    
    static void dfs(int cur) {
    	
    	dp[cur][0] = 0;
    	dp[cur][1] = 1;
    			
    	
    	for(int i=0; i<graph[cur].size(); i++) {
    		int next = graph[cur].get(i); 
    		if(isVisited[next]) continue; 
    		isVisited[next] = true;
    		parents[next] = cur;
    		dfs(next); 
    		
 
    	}
    	
    	for(int i=0; i<graph[cur].size(); i++) {
    		int next = graph[cur].get(i); 
    		if(parents[next]!=cur)continue;
    		dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
    		dp[cur][0] += dp[next][1];
    		
    	}
    	
    }
    
    
}