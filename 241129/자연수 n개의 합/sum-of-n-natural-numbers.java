import java.util.*;
import java.io.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    


    public static void main(String[] args)throws IOException {
        long limit = Long.valueOf(buffer.readLine()); 

        long h = limit;
        long l = 0; 


        while(h>l){
            long mid = (h+l+1)/2;

            if(isValid(mid, limit)){
                l = mid; 
            }else{
                h = mid-1;
            }

        }

        System.out.println(h);

    }


    private static boolean isValid(long query , long limit){
        return getSum(query)<=limit; 
    }


    private static long getSum(long query){
        return (query)*(query+1)/2; 
    }
}