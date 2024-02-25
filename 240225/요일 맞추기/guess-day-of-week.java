import java.io.*;
import java.util.*; 

public class Main {
    static int[] numOfDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] yoils = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


    static int getTotalDays(int month, int date){
        int totalDays = 0;

        for(int m=1; m<month; m++){
            totalDays+=numOfDays[m];
        }

        return totalDays+date; 
    }


    public static void main(String[] args)throws IOException {
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 

        int m1 = Integer.valueOf(tokens.nextToken());
        int d1 = Integer.valueOf(tokens.nextToken());

        int m2 = Integer.valueOf(tokens.nextToken());
        int d2 = Integer.valueOf(tokens.nextToken()); 

        int offset = getTotalDays(m2, d2) - getTotalDays(m1,d1); 
        
    
        int yoilData = offset%7; 
        

        if(yoilData<0){
            yoilData += 7; 
        }


        System.out.println(yoils[yoilData]);



    }
}