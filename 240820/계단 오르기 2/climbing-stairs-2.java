import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;


    public static void main(String[] args) throws IOException{
        
        int n = Integer.parseInt(buffer.readLine());

        int[] coins = new int[n+1];
        int[][] dp = new int[n+1][4];

        tokens = new StringTokenizer(buffer.readLine()); 

        for(int i=1; i<=n; i++){
            coins[i] = Integer.parseInt(tokens.nextToken());
        }

        dp[1][1] = coins[1]; 
        dp[2][0] = coins[2];
        dp[2][2] = coins[1]+coins[2]; 

        for(int i=3; i<=n; i++){
            for(int j=0; j<=3; j++){
                if(dp[i-2][j]!=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j]+coins[i]);
                }
                if(j>=1&&dp[i-1][j-1]!=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+coins[i]);
                }
            }
        }

        int result = 0;
        for(int j=0; j<=3; j++){
            result = Math.max(dp[n][j], result); 
        }
        System.out.println(result); 


    }
}