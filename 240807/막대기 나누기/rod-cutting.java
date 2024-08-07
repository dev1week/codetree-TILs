import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        int[] d = new int[n+1];
        //d[i]= 길이가 i일 때 최대 수익 
        int[] values = new int[n+1]; 

        tokens = new StringTokenizer(buffer.readLine()); 
        
        for(int i=1; i<=n; i++){
            values[i] = Integer.parseInt(tokens.nextToken()); 
        }

        d[0] = 0; 

        for(int totLength=1; totLength<=n; totLength++){
            for(int partLength=1; partLength<=n; partLength++){
                if(totLength-partLength<0)continue; 
                d[totLength] = Math.max(d[totLength], d[totLength-partLength]+values[partLength]);
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt()); 

    }
}