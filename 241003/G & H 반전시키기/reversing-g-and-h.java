import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        
        int n = Integer.parseInt(buffer.readLine());

        String data1 = buffer.readLine();
        String data2 = buffer.readLine(); 


        boolean isSame = false; 
        int cnt = 0; 

        for(int i=0; i<n; i++){
            if(data1.charAt(i)==data2.charAt(i)){
                isSame = true;
            }else{
                if(isSame||i==0){
                    cnt++;
                }
                isSame = false; 
            }

            //data1과 2의 현재 글자가 같을 경우 
                //연속일 경우 isSame = true
                    //
                //연속이지 않을 경우 isSame = false
                    // 

                //isSame = true; 
            //다를 경우 
                //연속일 경우 isSame = true 
                    //
                //연속이지 않을 경우
                    //cnt++
                //isSame = false; 
        }

        System.out.println(cnt);

    }
}