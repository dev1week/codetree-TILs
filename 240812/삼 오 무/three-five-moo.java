import java.io.*; 
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{


        int n = Integer.parseInt(buffer.readLine());


        System.out.println(binarySearch(n));

        
    }

    private static int binarySearch(int n){
    
        int l = 0;
        int h = (int) 1e9; 

        while(h>l){
            int mid = (l+h+1)/2; 
            int cnt = getNumberCnt(mid);
            //System.out.println(mid+" "+cnt); 
            if(cnt==n){
                return mid; 
            }else if(cnt<n){
                l = mid; 
            }else if(cnt>n){
                h = mid-1; 
            }
        }
        return l;

    }

    private static int getNumberCnt(int number){
        int t =  number/3;
        int f = number/5;
        int ft = number/15; 


        return number-t-f+ft; 
    }
}