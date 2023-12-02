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
    	getCentralNode(root);
    	
    	
//    	for(int node=0; node<=num; node++) {
//    		System.out.println(graph[node]); 
//    	}
    	
    	
    	
    	isVisited = new boolean[num+1];
    	isVisited[centralNode] = true; 
    	makeTreeDp(centralNode); 
    	
//    	System.out.println("중앙 노드 "+centralNode); 
//    	System.out.println("루트" +root);
    	List<Integer> childNodes = graph[centralNode];
//    	System.out.println("중앙 노드의 자식");
//    	System.out.println(graph[centralNode]);
//    	System.out.println(childNodes); 
    	
    	
    	List<Integer> result = getSubtreeSize(childNodes); 
    	
    	
    	
    	int min = 0;
    	int max = 0; 
    	if(result.size()!=0) {
    	 	min = result.get(0);
        	max = result.get(result.size()-1);

    	}
    	System.out.println(max-min);
    
    	
    }


	private static List<Integer> getSubtreeSize(List<Integer> childNodes) {
		List<Integer> result = new ArrayList<>();
		
		for(int childNode : childNodes) {
//			if(dp[centralNode]<dp[childNode])continue;
			result.add(dp[childNode]);
			
		}
//		System.out.println("서브트리 크기");
//    	System.out.println(result); 
		Collections.sort(result);
		
		return result;
	}


	private static void getCentralNode(int current) {
		//자식 노드 개수는 간선 -1 
		int numOfChild = graph[current].size()-1;
		//루트일 경우 부모가 없으므로 다시 자식노드 개수 +1 
		if(current==root) numOfChild++; 
		
//		System.out.println(current); 
		if(numOfChild>=2&&centralNode==0) {
			centralNode = current; 
			
		}
		
		if(numOfChild==0&&centralNode==0) {
			centralNode = current; 
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
			graph[node2].add(node1);
		}
		
	}
	
    
}