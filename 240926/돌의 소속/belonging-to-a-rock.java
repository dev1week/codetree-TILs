import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int[][] cnt; 
    static int[][] prefixSum; 


    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int q = Integer.parseInt(tokens.nextToken());

        cnt = new int[n+1][4]; 
        prefixSum = new int[n+1][4];

        for(int i=1; i<=n; i++){
            int group = Integer.parseInt(buffer.readLine()); 

            cnt[i][group] ++;

            for(int j=0; j<=3; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + cnt[i][j];
            }
        }

        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());

            for(int group=1; group<=3; group++){
                result.append(getPartSum(start, end, prefixSum, group)).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);





    }

    private static int getPartSum(int start, int end, int[][] prefixSum, int group){
        return prefixSum[end][group] - prefixSum[start-1][group]; 
    }
}