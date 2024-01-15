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
	 static int k; 
	 
	 static int[] queries; 
	 static Map<Integer, Integer> datas;
	 
	 
	 
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		k = Integer.valueOf(tokens.nextToken()); 
		
		queries = new int[n];
		
		
		tokens = new StringTokenizer(buffer.readLine());
		datas= new HashMap<>(); 
		for(int i=0; i<n; i++) {
			queries[i] = Integer.valueOf(tokens.nextToken());
			datas.put(queries[i], datas.getOrDefault(queries[i], 0)+1);
		}
		
		
	}
	
	
	public static void main(String[] args)throws IOException{
		init(); 
		int result = 0; 
		for(int query : queries) {
			int data = k - query; 
			
			if(datas.containsKey(data)) {
				
				result++;
			}
		}
		System.out.println(result/2); 
		
	}
    
}