import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        int[] numbers = Arrays.stream(buffer.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        
        int[] maxL = new int[n];
        int[] maxR = new int[n]; 

        maxL[0] = numbers[0];
        maxR[n-1] = numbers[n-1]; 

        for(int i=1; i<n; i++){
            maxL[i] = Math.max(numbers[i], maxL[i-1]);
        }

        for(int i=n-2; i>=0; i--){
            maxR[i] = Math.max(numbers[i],maxR[i+1]);
        }


        int result = 0; 
        for(int i=2; i<n-2; i++){
            int partSum = numbers[i] + maxL[i-2] + maxR[i+2];
            result = Math.max(partSum, result);
        }

        System.out.println(result);

    }
}