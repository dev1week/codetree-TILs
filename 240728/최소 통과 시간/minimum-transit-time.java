import java.io.*; 
import java.util.*; 
public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static final long MAX_TIME = 1000000001; 

    public static void main(String[] args)throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken()); 
        int m = Integer.parseInt(tokens.nextToken()); 

        long[] passTimes = new long[m];

        for(int i=0; i<m; i++){
            passTimes[i] = Long.parseLong(buffer.readLine()); 
        }

        long l =1; 
        long h = MAX_TIME; 

        while(h>l){
            long mid = (h+l)/2; 

            if(isValid(mid, passTimes, n)){
                h = mid;
            }else{
                l = mid+1;
            }

        }

        System.out.println(l);

    }

    private static boolean isValid(long target, long[] passTimes, int n){
        long passCount = 0;

        for(long time : passTimes){
            passCount+= (target/time);
        }

        return passCount>=n;

    }
}