import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); 

        int[] dp = new int[n]; 

        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = numbers[0];

        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+numbers[i], numbers[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
        
    }
}