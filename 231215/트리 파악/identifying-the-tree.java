import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


//말의 이동 
	//아무거나 하나 고른다. 
	//말의 노드의 부모로 옮긴다.
	//루트 노드 도착시 말 제거 

//노드	
	//여러개 말이 존재 가능 

//루트 노드 
	// 1 번 

//옮길 수 있는 말이 없는 상태인 사람의 패배 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static final int MAX_NODE = 100000;
    
    static int moveCount;
    static int n; 
    static boolean[] isVisited;
    static List<Integer>[] graph;
    
    static void init() throws IOException{
    	n = Integer.valueOf(buffer.readLine());
    	
    	graph = new List[MAX_NODE+1];
    	
    	for(int i=0; i<=MAX_NODE; i++) {
    		graph[i] = new ArrayList<>(); 
    	}
    	
    	for(int i=0; i<n-1; i++) {
    		tokens = new StringTokenizer(buffer.readLine());
    		int node1 = Integer.valueOf(tokens.nextToken());
    		int node2 = Integer.valueOf(tokens.nextToken());
    		
    		graph[node1].add(node2);
    		
    	}
    	
    	
    }
    
    public static void main(String[] args) throws IOException{
    	init();
    	
    	getMoveCount();
    	
    	if(isAWin()) {
    		System.out.println(1);
    	}else {
    		System.out.println(0);
    	}
    }
    
    static boolean isAWin() {
    	return moveCount%2==1;
    }
    
    static void getMoveCount() {
    	int root = 1;
    	
    	isVisited = new boolean[MAX_NODE+1];
    	isVisited[root] = true; 
    	dfs(1,0); 
    	
    }
    
    static void printTree() {
    	
    	for(int start = 0; start<graph.length; start++) {
    		if(graph[start].size()!=0) {
    			System.out.println(start+"->"+graph[start]);
    		}
    	}
    }
    
    static void dfs(int current, int depth) {
    	
    	if(graph[current].size()==0) {
    		
    		moveCount+=depth;
    		return;
    	}
    	//리프 노드인 경우 바로 total += depth; return;  
    	
    	//다음 노드 탐색 
    	for(int next : graph[current]) {
    		if(!isVisited[next] ){
    			isVisited[next] = true;
    			dfs(next, depth+1);
    		}
    	}
    	
    }
    
}