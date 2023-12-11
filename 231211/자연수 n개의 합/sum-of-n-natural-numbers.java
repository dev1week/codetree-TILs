import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
     
    static long limit;
    
    static long total(long end) {
    	return (1+end)*end/2;
    }
    
    static void init()throws IOException{
    	limit = Integer.valueOf(buffer.readLine());
    }
    
    
    public static void main(String[] args) throws IOException{
    	
    	init(); 
    	
    	//결정 조건 
    		//n일 때 총합이 s이하를 만족하는가?
    	
    	long l =1;
    	long r = limit;
    	
    	long result = 0;
    	
    	while(l<=r) {
    		
    		long mid = (l+r)/2; 
    		long s = total(mid);
    		
    		if(s<=limit) {
    			result = mid;
    			l = mid+1; 
    			
    		}else {
    			r = mid-1;
    		}
    		
    	}
    	System.out.println(result);	
    }
    

	
}