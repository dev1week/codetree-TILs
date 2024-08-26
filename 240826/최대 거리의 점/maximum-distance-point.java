import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{  
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        long[] points = new long[n];

        for(int i=0; i<n; i++){
            points[i] = Long.parseLong(buffer.readLine()); 
        }
        
        long l = 0;
        long h = points[n-1]; 


        while(h>l){
            long mid = (l+h+1)/2; 

            if(isValid(points, mid, m, n)){
                l = mid;
            }else{
                h = mid-1; 
            }
        }
        System.out.println(l); 
    }

    private static boolean isValid(long[] points, long mid, int m, int n){
        long currentPosition = points[0]; 
        long count = 1; 
        for(int i=1; i<n; i++){
            if(points[i]>=currentPosition+mid){
                count++;
                currentPosition = points[i];
            }
        }
        

        return count>=m; 
    }
}