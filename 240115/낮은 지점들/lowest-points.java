import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 
    
    public static void main(String[] args) throws IOException{
        
        int n = Integer.valueOf(buffer.readLine());
        Map<Long, Long> filter = new HashMap<>(); 
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine()); 
            long x = Long.valueOf(tokens.nextToken());
            long y = Long.valueOf(tokens.nextToken());

            if(filter.containsKey(x)){
                if(filter.get(x)>y){
                    filter.put(x,y); 
                }
            }else{
                filter.put(x,y);
            }
        }
        long result = 0; 
        for(long y : filter.values()){
            result+=y; 
        }

        System.out.println(result); 


        //n회 반복 
            //해쉬에 있는지 확인
                //있다
                    //키로 가져와서 입력값과 비교 
                        //작다 -> 넣는다. 
                //없다 
                    //바로 넣는다. 
    }
}