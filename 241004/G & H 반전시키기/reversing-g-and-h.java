import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());
        String data = buffer.readLine(); 
        String target = buffer.readLine();

        int cnt = 0; 
        boolean isPrevCharSame = false; 

        if(data.charAt(0)!=target.charAt(0)){
            isPrevCharSame = false; 
            cnt++; 
        }else{
            isPrevCharSame = true; 
        }

        for(int i=1; i<n; i++){
            if(data.charAt(i)==target.charAt(i)){
                // if(!isPrevCharSame){
                //     cnt++; 
                // }
                isPrevCharSame = true; 
            }else{
                if(isPrevCharSame){
                    cnt++; 
                }
                isPrevCharSame = false; 
            }
        }

        System.out.println(cnt); 
        //다른 구간의 갯수를 센다. 
        //전의 문자가 같았는지 달랐는지 식별 flag 

        //문자열을 순회한다. 
            //문자열이 서로 다르다
                //원래 달랐는지 체크하기    
                    //원래 달랐으면 같은 구간 
                    //전에서 같았으면 다른 구간 
                        //카운트한다. 
                        //플래그를 바꾼다. 
            //문자열이 서로 같다 
                //원래 같았는지 체크하기 
                    //원래 같았으면 같은 구간 
                    //전에서 달랐으면 다른 구간 
                    
    }
}