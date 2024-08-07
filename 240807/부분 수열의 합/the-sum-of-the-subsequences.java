import java.util.*;
import java.io.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args)throws IOException {
        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken()); 
        int m = Integer.parseInt(tokens.nextToken()); 

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 

        
        boolean[] isPossible = new boolean[m+1];

        isPossible[0] = true; 

        for(int number: numbers){
            for(int sum=m; sum>=1; sum--){
                if(sum-number<0)continue; 
                if(!isPossible[sum-number])continue;
                isPossible[sum] = true; 
            }
        }

        System.out.println(isPossible[m]?"Yes":"No"); 
    }
}