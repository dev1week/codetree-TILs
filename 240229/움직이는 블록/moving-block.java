import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.valueOf(buffer.readLine());


        int[] blocks = new int[n]; 
        int sum = 0; 
        for(int i=0; i<n; i++){
            

            blocks[i] = Integer.valueOf(buffer.readLine()); 
            sum += blocks[i]; 
        }


        int avg = sum/n; 
        int result = 0; 
        for(int block: blocks){
            if(avg<block){
                result += (block-avg);
            }
        }


        System.out.println(result); 

        //전체 총합을 구한다. 


        //무조건 많은 쪽에서 이동해야한다. 

        //넘는 것만 차이를 구한다. 


        
    }
}