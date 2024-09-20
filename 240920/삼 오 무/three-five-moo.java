import java.io.*;
import java.util.*; 


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        
        long n = Long.parseLong(buffer.readLine()); 


        System.out.println(binarySearch(1, (long) 1e9, n));


        
    }

    public static long binarySearch(long l, long h, long n){
        while(h>l){
            long mid = (l+h+1)/2; 

            long order = getOrder(mid);

            if(order==n){
                return mid;
            }else if(order<n){
                l = mid;
            }else if(order>n){
                h = mid-1; 
            }
        }
        return l; 
    }


    public static long getOrder(long mid){
        long by5 = mid/5;
        long by3 = mid/3;
        long by15 = mid/15;

        return mid-(by5+by3-by15);
    }
}