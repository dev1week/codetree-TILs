import java.util.*; 
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    public static void main(String[] args)throws IOException{
            TreeSet<Long> numbers = new TreeSet<>();

            tokens = new StringTokenizer(buffer.readLine());

            int n = Integer.valueOf(tokens.nextToken());
            int m = Integer.valueOf(tokens.nextToken()); 


            tokens = new StringTokenizer(buffer.readLine()); 
            //n개의 숫자 트리에 넣기 
            for(int i=0; i<n; i++){
                long number = Long.valueOf(tokens.nextToken());
                numbers.add(number); 
            }
            //m개의 숫자 트리에서 같거나 큰 최초의 숫자 구하기
            StringBuilder result = new StringBuilder(); 
            for(int i=0; i<m; i++){
                long query = Long.valueOf(buffer.readLine()); 
                if(numbers.ceiling(query)!=null){
                    result.append(numbers.ceiling(query)).append("\n");
                }else{
                    result.append(-1).append("\n");
                }
                
            } 

            System.out.println(result); 


    }
    
}