import java.io.*;
import java.util.*; 
public class Main {



    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[] numbers = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        int totSum = Arrays.stream(numbers).sum(); 
        
        boolean[] isPossible = new boolean[totSum+1]; 
        isPossible[0] = true; 
        for(int number: numbers){
            for(int partSum = totSum; partSum>=0; partSum--){
                if(partSum-number<0)continue; 
                if(!isPossible[partSum-number])continue;
                isPossible[partSum]=true; 
            }
        }

        //System.
        boolean result =false; 
        for(int partSum=1; partSum<=totSum; partSum++){
            if(isPossible[partSum]){
                if((totSum-partSum)-partSum==0) result = true; 
            }
        }


        System.out.println(result==true?"Yes":"No");

    }
}