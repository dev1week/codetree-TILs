import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        int[] coins = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        
        int[] dp = new int[m+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int sum=1; sum<=m; sum++){
            for(int coin :coins){
                if(sum-coin<0) continue; 
                if(dp[sum-coin]==Integer.MAX_VALUE) continue; 
                dp[sum] = Math.min(dp[sum], dp[sum-coin]+1);
            }

        }

        System.out.println(dp[m]==Integer.MAX_VALUE?0:dp[m]); 


    }
}