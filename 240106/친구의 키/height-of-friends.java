import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class Main {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens; 
	
	
	static int n; 
	static int m; 
	
	static List<Integer>[] graph; 
	static int[] indegree;
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine()); 
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken()); 
		
		graph = new ArrayList[n+1]; 
		indegree = new int[n+1]; 
		
		for(int i=0; i<=n; i++ ) {
			graph[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(buffer.readLine()); 
			
			
			int start = Integer.valueOf(tokens.nextToken()); 
			int end= Integer.valueOf(tokens.nextToken());
			
			graph[start].add(end); 
			indegree[end]++; 
		}
		
	}
	
	
	public static void main(String[] args)throws IOException{
		
		init(); 
		
//		System.out.println(Arrays.toString(indegree)); 
		StringBuilder result = new StringBuilder(); 
		Queue<Integer> que = new LinkedList<>();
		
		for(int node=1; node<=n; node++) {
			if(indegree[node]==0) {
				que.add(node); 
			}
		}
//		System.out.println(que); 
		while(!que.isEmpty()) {
			int node = que.poll(); 
			result.append(node+" ");
			for(int neighbor: graph[node]) {
				indegree[neighbor]--; 
				if(indegree[neighbor]==0) {
					que.add(neighbor);
				}
			}
			
		}
		
		System.out.println(result);
		
	}
    
}