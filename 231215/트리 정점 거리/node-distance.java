import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Edge{
	int dist;
	int end;
	
	public Edge(int dist, int end) {
		this.dist = dist;
		this.end = end;
	}
}


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n; 
    static int m; 
    
    static List<Edge>[] graph;
    
    static void init() throws IOException{
    	tokens = new StringTokenizer(buffer.readLine());
    	
    	n = Integer.valueOf(tokens.nextToken());
    	m = Integer.valueOf(tokens.nextToken());
    	
    	graph = new List[n+1];
    	
    	for(int i=0; i<=n; i++) {
    		graph[i] = new ArrayList<>(); 
    	}
    	
    	for(int i=0; i<n-1; i++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		int node1 = Integer.valueOf(tokens.nextToken());
    		int node2 = Integer.valueOf(tokens.nextToken());
    		int dist = Integer.valueOf(tokens.nextToken());
    		
    		graph[node1].add(new Edge(dist, node2));
    		graph[node2].add(new Edge(dist, node1));
    	}
    }
    
    public static void main(String[] args)throws IOException{
    	
    	init(); 
    	StringBuilder result = new StringBuilder();
    	for(int q=0; q<m; q++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		int start = Integer.valueOf(tokens.nextToken());
    		int end = Integer.valueOf(tokens.nextToken());
    		boolean[] isVisited = new boolean[n+1];
    		isVisited[start] = true;
    		getDist(start, end, 0, isVisited);
    		
    		result.append(queryResult).append("\n");
    	}
    	System.out.println(result);
    	
    	
    }
    
    static int queryResult = 0;
    static void getDist(int current, int target, int dist, boolean[] isVisited) {
    	
    	
    	if(target==current) {
    		queryResult = dist;
    		return; 
    	}
    	
    	for(Edge next : graph[current]) {
    		if(!isVisited[next.end]) {
    			isVisited[next.end] = true; 
    			getDist(next.end, target, dist+next.dist, isVisited);
    		}
    		
    	}
    	
    	
    	
    }
}