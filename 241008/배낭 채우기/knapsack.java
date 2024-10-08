import java.io.*;
import java.util.*; 

class Item{
    int w, v;

    public Item(int w, int v){
        this.w = w;
        this.v = v; 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        Item[] items = new Item[n]; 
        int[] dp = new int[m+1]; 
        Arrays.fill(dp, -1);
        dp[0] = 0; 


        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int w = Integer.parseInt(tokens.nextToken());
            int v = Integer.parseInt(tokens.nextToken()); 
            items[i] = new Item(w, v);
        }



        for(Item item: items){
            for(int sum=m; sum>=0; sum--){
                if(sum-item.w>=0){
                    if(dp[sum-item.w]==-1) continue; 
                    dp[sum] = Math.max(dp[sum], dp[sum-item.w]+item.v);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt()); 


    }
}