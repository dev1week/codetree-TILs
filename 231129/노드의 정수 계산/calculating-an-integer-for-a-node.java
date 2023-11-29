import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n; 
    
    static int[] dp; // dp[i] i번째 노드에 적힌 값 
    static int[] arr; // 초기값 
    static boolean[] isVisited; 
    
    static List<Integer>[] graph; 
    
    static void init() throws IOException{
    	
    	n = Integer.valueOf(buffer.readLine()); 
    	
    	graph = new List[n+1];
    	for(int node=0; node<=n; node++) {
    		graph[node] = new ArrayList<>();
    	}
    	isVisited = new boolean[n+1];
    	arr = new int[n+1]; 

    	for(int node=2; node<=n; node++) {
    		tokens = new StringTokenizer(buffer.readLine()); 
    		
    		int opt = Integer.valueOf(tokens.nextToken());
    		int value= Integer.valueOf(tokens.nextToken());
    		int parent = Integer.valueOf(tokens.nextToken()); 
    		
    		graph[parent].add(node);
    		
    		if(opt==0) {
    			arr[node] = -value;
    		}else {
    			arr[node] = value;
    		}
    	}
    }
    
    static void dfs(int cur) {
    	
    	dp[cur] = arr[cur];
    	for(int i=0; i<graph[cur].size(); i++) {
    		int child = graph[cur].get(i); 
    		if(isVisited[child])continue;
    		isVisited[child] = true; 
    		dfs(child);
    		
    		if(dp[child]>0) {
    			dp[cur] += dp[child];
    		}
    	}
    	
    	
    }
    
    static void makeTreeDp() {
    	dp = new int[n+1]; 
    	
    	
    	isVisited[1] = true;
    	dfs(1); 
    	
    	
    }
    
    public static void main(String[] args)throws IOException{
    	init(); 
    	
    	makeTreeDp(); 
    	
    	System.out.println(dp[1]);
    	
    }
    
    //부모 노드로 값을 전파 
    	//양수의 경우 
    		//부모 노드에 자신의 값을 더함
    	//음수의 경우 
    		//아무것도 안함 
    
    //마지막 루트인 1번 노드에 적히는 값 ?
    
    
    	
    
    
}