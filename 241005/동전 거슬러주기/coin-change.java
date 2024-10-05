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

        int[] d = new int[m+1]; 
        //d[i] = 총합이 i일 때 동전의 최대수 

        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0; 
        for(int sum=1; sum<=m; sum++){
            for(int coin: coins){
                if(sum-coin>=0&&d[sum-coin]!=Integer.MAX_VALUE){
                    d[sum] = Math.min(d[sum], d[sum-coin]+1);
                }
            }
        }
        //System.out.println(Arrays.toString(coins));
        //System.out.println(Arrays.toString(d));
        System.out.println(d[m]);

    }
}