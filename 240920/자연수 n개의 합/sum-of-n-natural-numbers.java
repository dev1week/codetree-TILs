import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException{
        long limit = Long.parseLong(buffer.readLine()); 


        long h = limit/2+1;
        long l = 1; 

        //가능한 n을 이진탐색으로 뽑아본다. 
            //뽑은 n을 가지고 총합을 계산하고 limit 이하인지 확인한다. 

        //최댓값 구하기 

        while(h>l){
            long mid = (l+h+1)/2; 

            if(isValid(mid, limit)){
                l = mid;
            }else{
                h = mid-1; 
            }
        }

        System.out.println(l);
    }

    private static boolean isValid(long mid, long limit){
       return sum(mid)<=limit;
    }

    private static long sum(long mid){
        return (mid+1)*mid/2; 
    }
}