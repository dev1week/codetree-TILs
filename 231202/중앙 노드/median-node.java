import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static List<Integer>[] graph; 
    static boolean[] isVisited; 
    static int centralNode; 
    
    static int[] dp; // i번 노드의 서브트리 크기 
    
    
    static int num; // 노드의 개수 
    static int root; // 루트 노드의 번호 
    
    public static void main(String[] args) throws IOException{
    	init(); 
    	
    	isVisited[root] =true; 
    	makeTreeDp(root); 
    	
//    	for(int node=0; node<=num; node++) {
//    		System.out.println(graph[node]); 
//    	}
    	
//    	System.out.println(Arrays.toString(dp));
    	
    	isVisited = new boolean[num+1];
    	isVisited[root] = true; 
    	getCentralNode(root);
//    	System.out.println(centralNode); 
    	
    	List<Integer> childNodes = graph[centralNode];
//    	System.out.println("중앙 노드의 자식");
//    	System.out.println(childNodes); 
    	
    	
    	List<Integer> result = getSubtreeSize(childNodes); 
    	
//    	System.out.println(result); 
    	
    	if(result.size()==0) {
    		System.out.println(0);
    	}else {
    	 	int min = result.get(0);
        	int max = result.get(result.size()-1);
        	
        	System.out.println(max-min);
    	}
    
    	
    }


	private static List<Integer> getSubtreeSize(List<Integer> childNodes) {
		List<Integer> result = new ArrayList<>();
		
		for(int childNode : childNodes) {
			result.add(dp[childNode]);
			
		}
		
		
		Collections.sort(result);
		
		return result;
	}


	private static void getCentralNode(int current) {
//		System.out.println(current); 
		if(graph[current].size()>=2||graph[current].size()==0) {
			centralNode = current; 
			return; 
		}
		
		for(int i=0; i<graph[current].size(); i++) {
			int child = graph[current].get(i); 
			if(isVisited[child])continue; 
			isVisited[child] = true; 
			getCentralNode(child); 
		}
		
	}


	private static void makeTreeDp(int current) {
		dp[current] = 1; 
		for(int i=0; i<graph[current].size(); i++) {
			int child = graph[current].get(i);
			if(isVisited[child])continue; 
			isVisited[child] = true; 
			makeTreeDp(child);
			dp[current]+= dp[child]; 
		}
	}

	


	private static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine()); 
		
		num = Integer.valueOf(tokens.nextToken()); 
		root = Integer.valueOf(tokens.nextToken()); 
		
		graph = new List[num+1]; 
		isVisited = new boolean[num+1];
		dp = new int[num+1]; 
		
		for(int i=0; i<=num; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<num-1; i++) {
			tokens = new StringTokenizer(buffer.readLine()); 
			int node1 = Integer.valueOf(tokens.nextToken()); 
			int node2 = Integer.valueOf(tokens.nextToken()); 
			
			graph[node1].add(node2);
		}
		
	}
	
    
}