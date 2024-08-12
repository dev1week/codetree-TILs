import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());
        int k = Integer.parseInt(buffer.readLine()); 

        long l = 1;
        long h = n*n; 

        while(h>l){
            long mid = (l+h+1)/2; 

            if(getLessNumberCnt(mid, n)>=k){
                h = mid;
            }else{
                l = mid+1; 
            }
        }

        System.out.println(l);

        //수를 이진탐색한다. 
            //해당 수가 k번째로 오는 수인지 검사한다. 
            //조건을 만족하는 최소값을 찾는다.             

    }

    private static long getLessNumberCnt(long mid, int n){
        long cnt = 0; 
        for(int row=1; row<=n; row++){
            cnt += Math.min(n, mid/row);
        }

        return cnt;
    }
}