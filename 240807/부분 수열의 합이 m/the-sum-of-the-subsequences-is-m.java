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
        int[] d = new int[m+1]; 
        //d[sum] = 부분 수열의 총합이 sum일 때 가능한 최소 수열의 길이 

        Arrays.fill(d, 101);

        d[0] = 0;

        for(int number: numbers){
            for(int sum=m; sum>=0; sum--){
                if(sum-number<0) continue; 
                if(d[sum-number]==101) continue;
                d[sum] = Math.min(d[sum], d[sum-number]+1); 
            }
        }

        System.out.println(d[m]==101? -1:d[m]);
        
    }
}