import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int root;
    static int n; 
    static List<Integer>[] graph; 
    
    static void init() throws IOException{
    	n = Integer.valueOf(buffer.readLine());
    	
    	graph = new ArrayList[n];
    	for(int i=0; i<n; i++) {
    		graph[i] = new ArrayList(); 
    	}
    	
    	tokens = new StringTokenizer(buffer.readLine());
    	for(int child=0; child<n; child++) {
    		int parent = Integer.valueOf(tokens.nextToken());
    		
    		if(parent==-1) {
    			root = child;
    			continue; 
    		}
    		
    		graph[parent].add(child);
    	}
    	
    }
    
    public static void main(String[] args)throws IOException{
    	//인접 리스트 형태로 그래프 만들기 (0번 노드부터 존재함)
    	//rootNode 찾기 
    	init();
    	
    	
    	
    	//주어진 노드 지우기 
    	int target = Integer.valueOf(buffer.readLine());
    	delete(target);
    	
    	maxDepth = 0;
    	leafCount= 0;
    	isVisited = new boolean[n];
    	//리프노드 개수 세기 
    	isVisited[root] = true;
    	countLeaf(root, 0);
    	
    	System.out.println(leafCount);
    }
    
    static void delete(int target) {
    	graph[target].clear();
    	
    	for(int node=0; node<n; node++) {
    		if(node==target)continue;
    		List<Integer> childrens = graph[node];
    		
    		for(int i=0; i<childrens.size(); i++) {
    			int child = childrens.get(i);
    			if(child == target) {
    				graph[node].remove(i);
    			}
    		}
    		
    	}
    }
    static int maxDepth;
    static int leafCount; 
    static boolean[] isVisited;
    static void countLeaf(int current, int depth) {
    	
    	for(int next : graph[current]) {
    		if(!isVisited[next]) {
    			isVisited[next] = true; 
    			if(depth+1==maxDepth) {
    				leafCount++;
    			}else if(depth+1>maxDepth) {
    				maxDepth = depth+1;
    				leafCount = 1;
    			}
    			
    			countLeaf(next, depth+1);
    			
    		}
    	}
    	
    }
    
   static void printGraph() {
	   for(int node=0; node<n; node++) {
		   System.out.println(graph[node]);
	   }
   }
}