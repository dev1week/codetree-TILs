import java.io.*;
import java.util.*; 




public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        
        int[] lenToV = new int[n+1]; 
        int[] dp = new int[n+1]; 
        Arrays.fill(dp, -1); 
        dp[0] = 0; 
        



        tokens = new StringTokenizer(buffer.readLine());
        for(int len=1; len<=n; len++){
            lenToV[len] = Integer.parseInt(tokens.nextToken()); 
        }

        for(int len=1; len<=n; len++){
            for(int sum=1; sum<=n; sum++){
                if(sum-len>=0){
                    if(dp[sum-len]==-1)continue; 

                    dp[sum] = Math.max(dp[sum], dp[sum-len]+lenToV[len]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt()); 
        

    }
}