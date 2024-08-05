import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[n];


        for(int i=0; i<n; i++){
            int result = 0; 
            for(int j=0; j<i; j++){
                if(numbers[i]>numbers[j]){
                    result = Math.max(result, d[j]); 
                }
                
            }
            result++; 
            d[i] = result;
        }   

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result, d[i]);
        }
        System.out.println(result); 

    }
}