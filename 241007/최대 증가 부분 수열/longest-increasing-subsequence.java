import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int[] d = new int[n]; 
        Arrays.fill(d,1); 

        for(int current=0; current<n; current++){
            for(int prev=0; prev<current; prev++){
                if(numbers[current]>numbers[prev]){
                    d[current] = Math.max(d[current], d[prev]+1); 
                }
            }
        }


        System.out.println(Arrays.stream(d).max().getAsInt());


       //d[i] = i번째 수까지 고려했을 때 가장 긴 증가 부분수열의 길이 
       //d[0] = 1

        
    }
}