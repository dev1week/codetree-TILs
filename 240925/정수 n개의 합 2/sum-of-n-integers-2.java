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
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }

        int result = 0; 
        for(int start=1; start<=n-k+1; start++){
            int end = start+k-1; 

            result = Math.max(result, getPartSum(start, end, prefixSum));

        }

        System.out.println(result);
        //1,2,3
        //2,3,4
        //3,4,5

    }
    private static int getPartSum(int start, int end, int[] prefixSum){
        return prefixSum[end]- prefixSum[start-1]; 
    }
  
}