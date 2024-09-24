import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken()); 


        int[] numbers = new int[n+1];
        int[] prefixSum = new int[n+1]; 

        tokens = new StringTokenizer(buffer.readLine());

        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken());
        }
        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1]+numbers[i];
        }

        int count = 0; 
        for(int consecutiveNumber=1; consecutiveNumber<=n; consecutiveNumber++){
            for(int i=1; i<=n-consecutiveNumber+1; i++){
                if(getPartSum(i, i+consecutiveNumber-1, prefixSum)==k){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static int getPartSum(int s, int e, int[] prefixSum){
        return prefixSum[e] - prefixSum[s-1]; 
    }
}