import java.io.*;
import java.util.*; 
public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    private static final int[] numbers= {1,2,5};
    private static final int data= 10007; 

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(buffer.readLine()); 
        int[] d= new int[n+1]; 
        d[0] = 1; 

        for(int sum = 1; sum<=n; sum++){
            for(int number: numbers){
                //if(sum==number)continue; 
                if(sum-number<0)continue; 
                //if(d[sum-number]==-1)continue; 
                d[sum] += d[sum-number];
                d[sum] %= data; 
            }
        }
        
        System.out.println(d[n]);

    }
}