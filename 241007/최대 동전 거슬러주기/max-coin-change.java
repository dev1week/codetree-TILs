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
        Arrays.fill(dp, -1); 
        dp[0] = 0;

        for(int coin: coins){
            for(int sum=0; sum<=m; sum++){
                if(sum-coin>=0){
                    if(dp[sum-coin]==-1)continue; 
                    dp[sum] = Math.max(dp[sum], dp[sum-coin]+1); 
                }
            }
        }
        System.out.println(dp[m]); 

    }
}