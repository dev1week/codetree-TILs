import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 


        int[] numbers = new int[n];
        
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(buffer.readLine());
        }

        long h = (long) 1e5; 
        long l = 1;

        while(h>l){
            long mid = (h+l+1)/2; 


            if(count(numbers, mid)>=m){
                l = mid;
            }else{
                h = mid-1; 
            }
        }

        System.out.println(l); 
    }

    private static long count( int[] numbers, long mid){
        int result = 0;

        for(int number: numbers){
            result += (number/mid);
        }

        return result; 

    }
}