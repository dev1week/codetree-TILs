import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        //d[i] =   합이 i일 때 가능한 수열의 최소 길이 

        //d[0] = 0; 
        //나머지는 Integer.MAX_VALUE 
        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken()); 
        int m = Integer.parseInt(tokens.nextToken()); 

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int[] dp = new int[m+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        for(int number: numbers){
            for(int sum=m; sum>=0; sum--){
                if(sum-number>=0){
                    if(dp[sum-number]==Integer.MAX_VALUE)continue; 
                    dp[sum] = Math.min(dp[sum-number]+1, dp[sum]); 
                }
            }
        }

        System.out.println(dp[m]==Integer.MAX_VALUE?-1:dp[m]); 

    }
}