import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static long n; //점의 갯수 
    
    
    static boolean isPossible(long k) {
    	
    	long mooCount = k/3+k/5-k/15; 
    	
    	return k-mooCount>=n;
    	
    }
    
    public static void main(String[] args) throws IOException{
    	n = Long.valueOf(buffer.readLine()); 
    	
    	
    	long left = 1;
    	long right = Integer.MAX_VALUE;
    	long result = Integer.MAX_VALUE;
    	
    	while(left<=right) {
    		long mid = (left+right)/2;
    		
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