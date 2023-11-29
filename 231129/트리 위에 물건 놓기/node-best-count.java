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
    static boolean[] isVisited2; 
    
    static void init() throws IOException{
    	n = Integer.valueOf(buffer.readLine());
    	
    	graph = new List[n+1];
    	isVisited = new boolean[n+1]; 
    	isVisited2 = new boolean[n+1];
    	
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
    	int root = 0; 
    	int value = 0;
    	for(int node=1; node<=n; node++) {
    		if(dp[node][0]+dp[node][1]>value) {
    			root = node;
    			value = dp[node][0] + dp[node][1];
    		}
    	}
    	
    	System.out.println(Math.min(dp[root][0], dp[root][1]));
    }
    
    static void makeDp() {
    	
    	dp = new int[n+1][2];
    	isVisited2[1] = true;
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
    		dfs(next); 
    		
 
    	}
    	
    	for(int i=0; i<graph[cur].size(); i++) {
    		int next = graph[cur].get(i); 
    		if(isVisited2[next]) continue; 
    		isVisited2[next] = true;
    		dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
    		dp[cur][0] += dp[next][1];
    		
    	}
    	
    }
    
    
}