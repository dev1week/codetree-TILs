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


        tokens = new StringTokenizer(buffer.readLine());
        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
        }
        int[] prefixSum = new int[n+1];

        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1]+ numbers[i];
        }

        int result = 0; 

        for(int i=1; i<=n-k+1; i++){
            result = Math.max(result, getPartSum(i, i+k-1, prefixSum, numbers));
        }


        System.out.println(result); 
        //System.out.println(Arrays.toString(prefixSum)); 

        //1~n개 원소의 합 구하기 
            //1개 원소의 합일 경우 
    }

    private static int getPartSum(int s, int e, int[] prefixSum, int[] numbers){
        return prefixSum[e] - prefixSum[s] + numbers[s];
    }
}