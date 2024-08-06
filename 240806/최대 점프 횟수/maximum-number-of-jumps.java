import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[]  numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[n]; 

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(numbers[j]+j>=i){
                    d[i] = d[j]+1; 
                }

            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt()); 
        
    }
}