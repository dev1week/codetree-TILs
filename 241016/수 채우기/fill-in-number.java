import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static final int[]coins = {5,2};


    public static void main(String[] args) throws IOException{
        int cnt = 0; 
        int tot = Integer.parseInt(buffer.readLine()); 


        while(tot>0){
            if(tot%5==0){
                tot = tot-5;
                
            }else{
                tot = tot-2; 
                 
            }

            //System.out.println(tot);
            cnt++;
        }
        

        if(tot==0){
            System.out.println(cnt); 
        }else{
            System.out.println(-1);
        }


    }
}