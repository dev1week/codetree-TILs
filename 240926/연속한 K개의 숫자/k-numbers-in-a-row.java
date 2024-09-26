import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken());


        int[] cnt = new int[n+1];
        int[] prefixSum = new int[n+1];

        for(int i=0; i<b; i++){
            int blankIdx = Integer.parseInt(buffer.readLine());
            cnt[blankIdx]++;
        }

        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + cnt[i];
        }

        int result = Integer.MAX_VALUE; 
        for(int start=1; start<=n-k+1; start++){
            // 1 2 3 4 5
            // 1 2 3 
            // 2 3 4 
            // 3 4 5 
            int end = start+k-1; 

            result = Math.min(result, getPartSum(start, end, prefixSum));
        }
        System.out.println(result); 
    }

    private static int getPartSum(int start, int end, int[] prefixSum){
        return prefixSum[end] - prefixSum[start-1];
    }
}