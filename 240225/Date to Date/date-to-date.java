import java.io.*;
import java.util.*; 
public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    
    static int[] numOfDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    

    static int getTotalDates(int month, int date){
        int totalDates = 0; 
        for(int m=1; m<month; m++){
            totalDates+=numOfDays[m];
        }

        return totalDates+date; 

    }



    public static void main(String[] args) throws IOException{
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 

        int m1 = Integer.valueOf(tokens.nextToken());
        int d1 = Integer.valueOf(tokens.nextToken());
        int m2 = Integer.valueOf(tokens.nextToken());
        int d2 = Integer.valueOf(tokens.nextToken()); 

        int result = getTotalDates(m2, d2) - getTotalDates(m1,d1)+1;

        System.out.println(result);  

    }
}