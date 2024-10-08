import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
                                                         
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int totSum = Arrays.stream(numbers).sum(); 
        int[] dp = new int[totSum+1]; 
        Arrays.fill(dp, -1);
        dp[0] =0; 

        for(int number : numbers){
            for(int sum=totSum; sum>=0; sum--){
                if(sum>=number){
                    if(dp[sum-number]==-1)continue; 
                    dp[sum] = Math.max(dp[sum],dp[sum-number]+1 );
                }
            }
        }
        int result = Integer.MAX_VALUE; 
        for(int partAsum=1; partAsum<totSum; partAsum++){
            if(dp[partAsum]==-1)continue; 
            int partBsum = totSum - partAsum; 
            result = Math.min(result, Math.abs(partAsum-partBsum));
        }

        System.out.println(result); 
        

    }
}