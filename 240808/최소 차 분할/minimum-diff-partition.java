import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());
        int[] numbers = new int[n];

        tokens = new StringTokenizer(buffer.readLine());
        int tot = 0; 
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
            tot+=numbers[i]; 
        }

        boolean[] d = new boolean[tot+1]; 
        d[0] = true; 

        for(int number: numbers){
            for(int sum=tot; sum>=0; sum--){
                if(sum-number<0)continue; 
                if(!d[sum-number])continue; 
                d[sum] = true;
            }
        }

        //System.out.println(Arrays.toString(d)); 

        int result = Integer.MAX_VALUE;
        for(int sum=0; sum<=tot; sum++){
            if(d[sum]){
                result = Math.min(result, Math.abs((tot-sum) -sum));
            }
        }
        // System.out.println(tot); 
        // System.out.println(Arrays.toString(d)); 
        System.out.println(result); 
        
        
    }
}