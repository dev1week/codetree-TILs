import java.io.*;
import java.util.*; 
import java.util.stream.*; 

public class Main {

    static BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        
        List<Integer> numbers = buffer.lines()
                                      .limit(n) 
                                      .map(Integer::parseInt) 
                                      .collect(Collectors.toList()); 

        
        int max = numbers
                    .stream()
                    .map(Integer::intValue)
                    .max(Integer::compareTo)
                    .orElse(0); 

        int h = max;
        int l = 0; 

        while(h>l){
            int mid = (h+l+1)/2; 

            if(isValid(numbers, m,mid )){
                l = mid;
            }else{
                h = mid-1; 
            }
        }

        System.out.println(h); 
    }

    private static boolean isValid(List<Integer> numbers, int limit, int query){
        int cnt = 0; 
        for(int number: numbers){
            cnt += (number/query);
        }
        //System.out.println(query+":"+cnt); 
        return cnt>=limit;

    }
}