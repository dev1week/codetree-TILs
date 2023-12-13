import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Edge{
	int end;
	int dist; 
	
	public Edge(int end, int dist) {
		this.end = end;
		this.dist = dist; 
	}
	
	
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n; 
    static List<Edge>[] graph; 
    static boolean[] isVisited;
    
    static void init()throws IOException{
    	n = Integer.valueOf(buffer.readLine()); 
    	graph = new ArrayList[n+1];
    	
    	for(int node=0; node<=n; node++) {
    		graph[node] = new ArrayList<>();
    	}
    	
    	for(int node=0; node<n-1; node++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		
    		int node1 = Integer.valueOf(tokens.nextToken());
    		int node2 = Integer.valueOf(tokens.nextToken());
    		int dist = Integer.valueOf(tokens.nextToken());
    		
    		graph[node1].add(new Edge(node2, dist));
    		graph[node2].add(new Edge(node1, dist));
    		
    	}
    	
    }
    
    public static void main(String[] args)throws IOException{
    	init(); 
    	
    	
    	tmpTotal = 0;
    	isVisited = new boolean[n+1];
    	int root = 1; 
    	//root에서 부터출발하여 x 찾아내
    	isVisited[root] = true;
    	findFarthestNodeFrom(root, 0);
//    	System.out.println(x+" "+tmpTotal);
    	
//    	System.out.println("x 찾기 끝 ");
//    	System.out.println(x+" "+tmpTotal);
//    	System.out.println(" ");
    	//
    	tmpTotal = 0;
    	isVisited = new boolean[n+1];
    	isVisited[x] = true;
    	findFarthestNodeFrom(x, 0);
//    	
//    	
    	System.out.println(tmpTotal);
    	
    	
    }
    
    static int tmpTotal;
    static int x;
    static void findFarthestNodeFrom(int current, int total) {
    	
    	for(Edge node : graph[current]) {
    		int nextNode = node.end;
    		if(!isVisited[nextNode]) {
    			
    			isVisited[nextNode] = true;
    			int nextTotal = total+ node.dist;
//    			System.out.println(nextNode+" "+nextTotal);
    			if(nextTotal>tmpTotal) {
    				x = nextNode;
    				tmpTotal = nextTotal;
    			}
    			findFarthestNodeFrom(nextNode, nextTotal);
    		}
    	}
    	
    }
    
    
    
    
    

	
}