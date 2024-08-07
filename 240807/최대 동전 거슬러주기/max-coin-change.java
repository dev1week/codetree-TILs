import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args)throws IOException {
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 


        int[] coins = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int[] d = new int[m+1]; 

        Arrays.fill(d, -1); 
        d[0] = 0; 

        for(int coin : coins){
            for(int sum=0; sum<=m; sum++){
                if(sum-coin<0) continue; 
                if(d[sum-coin]==-1)continue; 
                d[sum] = Math.max(d[sum], d[sum-coin]+1);
            }
        }
        
        
        System.out.println(d[m]); 
    }
}