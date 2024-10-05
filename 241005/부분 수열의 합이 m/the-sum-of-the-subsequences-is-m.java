import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        //int[] coins = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 

        int[] d = new int[m+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0; 
        

        //d[i] = 합이 i일 때 부분 수열의 최소 길이 

        
        for(int number: numbers){
            for(int sum=m; sum>=0; sum--){
                if(sum-number>=0&&d[sum-number]!=Integer.MAX_VALUE){
                    d[sum] = Math.min(d[sum], d[sum-number]+1);
                }
            }
        }

        System.out.println(d[m]==Integer.MAX_VALUE?-1:d[m]);
    }
}