import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        int n = Integer.parseInt(buffer.readLine()); 
        
        
        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 


        
        //현재 최대합
        int result = Integer.MIN_VALUE;
        //현재 구간합 
        int partSum = 0; 
        for(int i=0; i<n; i++){
            
            //현재 i로 구간합을 구해본다. 
            // int tmp = partSum + numbers[i];
            //구간합이 음수가 되었다. 
            if(partSum<0){
                partSum = numbers[i]; 
            }else{
                partSum += numbers[i];
                
            }
            result = Math.max(partSum, result); 
            
            // 구간합이 

        }
        System.out.println(result);

    }
}