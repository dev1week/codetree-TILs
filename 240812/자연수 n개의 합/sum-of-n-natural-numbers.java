import java.io.*; 
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        long s = Long.parseLong(buffer.readLine()); 

        long l = 0;
        long h = s; 
        
        while(h>l){
            long mid = (l+h+1)/2;

            if(isValid(mid, s)){
                l = mid;
            }else{
                h = mid-1;
            }
        }
            

        System.out.println(l); 
    }

    private static boolean isValid(long mid, long limit){
        long sum = (mid)*(mid+1)/2; 

        return sum<=limit; 
    }
}