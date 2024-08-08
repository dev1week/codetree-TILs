import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());
        int[] numbers = new int[n];

        tokens = new StringTokenizer(buffer.readLine());
        int tot = 0; 
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
            tot+=numbers[i]; 
        }

        int[] d = new int[tot+1]; 
        Arrays.fill(d,-1); 
        d[0] = 0; 

        for(int number: numbers){
            for(int sum=tot; sum>=0; sum--){
                if(sum-number<0)continue; 
                if(d[sum-number]==-1)continue; 
                d[sum] = Math.max(d[sum], d[sum-number]+1);
            }
        }

        //System.out.println(Arrays.toString(d)); 

        int result = Integer.MAX_VALUE;
        for(int sum=1; sum<=tot; sum++){
            if(d[sum]!=-1){
                result = Math.min(result, tot-sum);
            }
        }
        System.out.println(result); 
        
        
    }
}