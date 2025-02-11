import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    public static void main(String[] args) throws IOException{
        long n = Integer.parseInt(buffer.readLine()); 
        long k = Long.parseLong(buffer.readLine()); 

        System.out.println(binarySerach(n,k));
        
    }


    private static long binarySerach(long n, long k){
        long l = 1;
        long h = n*n;


        //System.out.println(h); 

        while(h>l){
            long mid = (l+h)/2; 
            //System.out.println(mid); 

            long result = 0;

            for(int i=1; i<=n; i++){
                result += Math.min(n,(mid/i));
            }

            //System.out.println(mid+"는 "+result+"번째 숫자입니다."); 
            if(result==k){
                return mid; 
            }else if(result>k){
                h = mid; 
            }else if(result<k){
                l = mid+1; 
            }
        }

        return l; 
    }
}