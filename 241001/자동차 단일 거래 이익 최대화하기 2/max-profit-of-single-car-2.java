import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        int[] costs = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int[] lMin = new int[n];
        int[] rMax = new int[n]; 

        lMin[0] = costs[0];
        rMax[n-1] = costs[n-1]; 

        for(int i=1; i<n; i++){
            lMin[i] = Math.min(costs[i], lMin[i-1]);
        }

        for(int i=n-2; i>=0; i--){
            rMax[i] = Math.max(costs[i], rMax[i+1]);
        }

        int result = 0; 
        for(int i=0; i<n; i++){
            result = Math.max(rMax[i]-lMin[i], result); 
        }

        if(result<=0){
            System.out.println(0);
        }else{
            System.out.println(result);
        }



    }
}