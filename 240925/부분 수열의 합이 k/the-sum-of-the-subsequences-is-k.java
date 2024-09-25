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
            prefixSum[i] = prefixSum[i-1]+numbers[i];
        }


        int cnt = 0; 
        //모든 연속된 구간의 합 구하기 
        for(int partSumLength = 1; partSumLength<=n; partSumLength++){

            for(int start=1; start<=n-partSumLength+1; start++){
                int end = start+partSumLength-1; 
                if(k==getPartSum(start, end, prefixSum)){
                    cnt++; 
                }
            }

        }

        System.out.println(cnt); 
        //길이가 1일 때 

        //길이가 2일 때 

        //길이가 3일 때 


        
        

    }

    private static int getPartSum(int s, int e, int[] prefixSum){
        return prefixSum[e] - prefixSum[s-1]; 
    }
}