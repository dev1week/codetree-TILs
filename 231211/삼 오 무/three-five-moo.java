import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n; //점의 갯수 
    
    
    static boolean isPossible(int k) {
    	
    	int mooCount = k/3+k/5-k/15; 
    	
    	return k-mooCount>=n;
    	
    }
    
    public static void main(String[] args) throws IOException{
    	n = Integer.valueOf(buffer.readLine()); 
    	
    	
    	int left = 1;
    	int right = Integer.MAX_VALUE;
    	int result = Integer.MAX_VALUE;
    	
    	while(left<=right) {
    		int mid = (left+right)/2;
    		
    		if(isPossible(mid)) {
    			right = mid-1;
    			result = Math.min(result, mid);
    		}else {
    			left = mid+1;
    		}
    		
    	}
    	System.out.println(result);
    	
    }
    
    

	
}