import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{
        //d[i]= i까지 고려했을 때 최대 점프 횟수 
        int n = Integer.parseInt(buffer.readLine()); 
        int[] jumps = new int[n]; 
        int[] d = new int[n]; 


        tokens = new StringTokenizer(buffer.readLine()); 

        for(int i=0;i<n; i++){
            jumps[i] = Integer.parseInt(tokens.nextToken());
        }

        for(int current=0; current<n; current++){
            for(int prev=0; prev<current; prev++){
                if(prev+jumps[prev]>=current){
                    d[current] = Math.max(d[current], d[prev]+1); 
                }
            }
        }

        //System.out.println(Arrays.toString(d)); 
        int result = 0; 
        for(int dp : d){
            result = Math.max(dp, result); 
        }

        System.out.println(result); 



        //전부 순회한다. current
            //current 이전까지 순회한다. 
                //이전좌표에서 현재 좌표까지 커버할 수 있는지 확인한다. 
                    //d[current] = Math.max(d[current], d[prev]+1)
    }
}