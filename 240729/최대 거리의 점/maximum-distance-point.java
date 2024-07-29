import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        long[] positions = new long[n];

        for(int i=0; i<n; i++){
            positions[i] = Long.parseLong(buffer.readLine());
        }
        Arrays.sort(positions); 

        long l = 0;
        long h = 1000000000; 


        while(h>l){
            long mid = (h+l+1)/2; 

            if(isValid(mid, positions, m)){
                l = mid; 
            }else{
                h = mid-1; 
            }
        }
        System.out.println(l);
    }

    private static boolean isValid(long target, long[] positions, int m){
        int lastIdx = 0;
        int cnt = 1;

        for(int idx=1; idx<positions.length; idx++){
            long currentDistance = positions[idx] - positions[lastIdx];

            if(currentDistance>=target){
                cnt++;
                lastIdx = idx;

            }
        }
        return cnt>=m; 

    }
}