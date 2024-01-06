import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class Main {
	
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens; 
	
	static List<Integer>[] graph;
	static int[] indegree; 
	
	static int n;
	static int m; 
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken());
		
		
		indegree = new int[n+1];
		graph = new List[n+1];
		
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(buffer.readLine());
			int start = Integer.valueOf(tokens.nextToken());
			int end = Integer.valueOf(tokens.nextToken()); 
			
			graph[start].add(end); 
			indegree[end]++; 
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		init(); 
		
		Queue<Integer> que = new LinkedList<>(); 
		for(int node=1; node<=n; node++) {
			if(indegree[node]==0) {
				que.add(node); 
			}
		}
		
		//전체 노드를 돌며 indegree ==0 인 노드를 큐에 넣는다. 
		
		int queAddCount = 0; 
		while(!que.isEmpty()) {
			int node = que.poll();
			queAddCount++;
			
			for(int neighbor: graph[node]) {
				indegree[neighbor]--;
				if(indegree[neighbor]==0) {
					que.add(neighbor); 
				}
			}
			
		}
		
		if(queAddCount!=n) {
			System.out.println("Inconsistent");
		}else {
			System.out.println("Consistent"); 
		}
		//큐가 빌 때까지 
			//큐를 꺼낼때마다 큐에서 꺼낸 값 카운트 ++ 
			//큐에서 꺼낸값에 연관된 노드 탐색 
				//해당 노드들 indegree --;
				//해당 노드의 indegree ==0인 경우 큐에 넣기 
		
		
		//큐에서 꺼낸 값 != n 

		
	}
    
}