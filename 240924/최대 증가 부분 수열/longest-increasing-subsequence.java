import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[] numbers = new int[n+1];

        tokens = new StringTokenizer(buffer.readLine());

        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
        }
        

        int[] dp = new int[n+1];

        Arrays.fill(dp, 1);
        

        for(int current=1; current<=n; current++){
            for(int prev=1; prev<current; prev++)
            if(numbers[current]>numbers[prev]){
                dp[current] = Math.max(dp[prev]+1, dp[current]); 
            }
        }

        int result = 0;

        for(int i=1; i<=n; i++){
            result = Math.max(result, dp[i]);
        }

        //System.out.println(Arrays.toString(dp)); 

        System.out.println(result); 
    }
}