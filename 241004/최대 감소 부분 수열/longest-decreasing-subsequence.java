import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[] numbers = new int[n+1]; 
        
        int[] dp = new int[n+1]; 
        dp[1] = 1; 

        tokens = new StringTokenizer(buffer.readLine()); 
        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
        }

        for(int current=1; current<=n; current++){
            for(int prev=1; prev<current; prev++){
                if(numbers[current]<numbers[prev]){
                    dp[current] = Math.max(dp[current], dp[prev]+1);
                }
            }
        }

        int result = 0; 
        for(int d : dp){
            result = Math.max(d, result);
        }


        //System.out.println(Arrays.toString(dp)); 
        System.out.println(result); 
    
    }
}