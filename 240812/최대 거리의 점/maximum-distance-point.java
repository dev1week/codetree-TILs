import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        

        long[] points = new long[n];

        for(int i=0; i<n; i++){
            points[i] = Long.parseLong(buffer.readLine()); 
        }


        //가장 인접한 두 물건의 거리 임의로 구하기 ->최댓값 
        long l =0;
        long h = (long) 1e9;

        while(h>l){
            long mid = (l+h+1)/2; 
            //System.out.println(mid); 
            if(isValid(mid, points, m)){
                l = mid; 
            }else{
                h = mid-1; 
            }
        }
        System.out.println(l);
    }

    private static boolean isValid(long mid, long[] points, int limit){
        long lastPoint = points[0]; 
        int cnt = 1; 
        for(long point : points){
            if(point>= lastPoint+mid){
                lastPoint = point; 
                cnt++;             
            }
        }

        return cnt>=limit; 
    }

}