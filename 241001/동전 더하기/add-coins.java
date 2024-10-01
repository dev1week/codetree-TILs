import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken()); 

        int[] coins = new int[n]; 

        for(int i=n-1; i>=0; i--){
            coins[i] = Integer.parseInt(buffer.readLine());
        }


        int cnt = 0; 
        for(int coin : coins){
            cnt += (k/coin);
            k %= coin;
        }

        System.out.println(cnt);


    }
}