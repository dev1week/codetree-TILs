import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static int n;
    static Map<String, Integer> count; 
    

    static void init() throws IOException{

        n = Integer.valueOf(buffer.readLine()); 
        count = new HashMap<>(); 
        for(int i=0; i<n; i++){
            String data = buffer.readLine(); 
            char[] charData = data.toCharArray(); 
            Arrays.sort(charData); 
            String convertData = new String(charData); 
            count.put(convertData, count.getOrDefault(convertData,0)+1);

        }
        
        //n개 입력을 받는다. 
            //문자열 -> char 배열 
            //정렬 
            //char 배열 -> 문자열 
            //해시맵에 넣기 
    }

    public static void main(String[] args)throws IOException{
        init(); 

        
        int maxCount = Integer.MIN_VALUE; 
        for(String key : count.keySet()){
            maxCount = Math.max(maxCount, count.get(key));     
        }
        System.out.println(maxCount); 
        
        //해쉬맵 내 키 전부 순회 
            //카운트가 높은 거 갱신 


        //최종 갱신 내역 출력 


    }
    
}