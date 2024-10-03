import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{

        // 여기에 코드를 작성해주세요.
        int n = Integer.parseInt(buffer.readLine());
        String data = buffer.readLine();
        String target = buffer.readLine(); 
        boolean negativeFlag = false; //얘가 켜져있으면 g는 h로 h는 g로 읽는다. 

        int cnt = 0;
        for(int i=n-1; i>=0; i--){
            if(negativeFlag){
                if(convert(data.charAt(i))!=target.charAt(i)){
                    cnt++; 
                    negativeFlag=!negativeFlag;
                }
            }else{
                if(data.charAt(i)!=target.charAt(i)){
                    cnt++; 
                    negativeFlag=!negativeFlag;
                }

                
            }
            //역전 세계일 경우
                //data1의 글자를 읽을 때 반대로 읽는다. 
                    //서로 글자가 다를 경우 
                        //플래그 변경 
                        //카운트 시작 
                    //서로 글자가 같을 경우 
                        
            //역전 세계가 아닐 경우 
                //data1의 글자를 바로 읽는다.
                    //서로 글자가 다를 경우 
                    //서로 글자가 같을 경우  
         
        }

        
        System.out.println(cnt);


        
    }
    private static char convert(char c){
            if(c=='G'){
                return 'H';
            }else{
                return 'G';
            }
        }
}