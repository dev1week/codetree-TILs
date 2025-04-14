import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException {
            tokens = new StringTokenizer(buffer.readLine());
            int n = Integer.parseInt(tokens.nextToken());
            int q = Integer.parseInt(tokens.nextToken()); 

            List<Integer> numbers = new ArrayList<>();
            tokens = new StringTokenizer(buffer.readLine());
            for(int i=0; i<n; i++){
                numbers.add(Integer.parseInt(tokens.nextToken()));
            }
            
            HashMap<Integer, Integer> map = new HashMap<>();  
            int cnt = 1; 
            for(int number: numbers){
                map.put(number, cnt);    
                cnt++;
            }


            StringBuilder result = new StringBuilder(); 
            for(int query=0; query<q; query++){
                tokens = new StringTokenizer(buffer.readLine()); 
                int start = Integer.parseInt(tokens.nextToken());
                int end = Integer.parseInt(tokens.nextToken());
                result.append(map.get(end)-map.get(start)+1).append("\n");
            }

            System.out.println(result);
    }
}