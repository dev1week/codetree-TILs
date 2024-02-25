import java.io.*;
import java.util.*; 


public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        
        int beforeHour = Integer.valueOf(tokens.nextToken());
        int beforeMin = Integer.valueOf(tokens.nextToken()); 

        int afterHour = Integer.valueOf(tokens.nextToken());
        int afterMin = Integer.valueOf(tokens.nextToken()); 
        

        int offset =  (60*afterHour+afterMin)-(60*beforeHour+beforeMin) ;

        System.out.println(offset); 


    }
}