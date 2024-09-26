import java.io.*; 
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static final long MAX_SIZE = (long) 1e10; 
    public static void main(String[] args) throws IOException{
        

        long l = 1;
        long h = MAX_SIZE; 
        long s = Long.parseLong(buffer.readLine());
        while(h>l){
            long mid = (l+h+1)/2; 

            if(isValid(mid, s)){
                l = mid; 
            }else{
                h = mid-1; 
            }

        }

        System.out.println(h); 
        //n을 이진 탐색으로 본다. 
            //1~n의 총합이 s 이하인지 확인한다. 

        

    }

    private static boolean isValid(long mid, long s){
        return getSum(mid)<=s;
    }

    private static long getSum(long mid){
        return (mid)*(mid+1)/2; 
    }
}