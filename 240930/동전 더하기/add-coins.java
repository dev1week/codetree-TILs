import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken()); 
        int k = Integer.parseInt(tokens.nextToken()); 

        int currentIdx = 0; 
        int coinCnt = 0; 

        Integer[] coins = new Integer[n]; 
        int balance = k; 

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(buffer.readLine()); 
        }

        Arrays.sort(coins, Collections.reverseOrder()); 

        while(balance>0){
            if(currentIdx>=n) break; 

            if(balance - coins[currentIdx]>=0){
                balance -= coins[currentIdx]; 
                coinCnt++; 
            }else{
                currentIdx++; 
            }
        }


        System.out.println(coinCnt); 
        


        //현재 고려중인 동전의 인덱스 

        //현재 잔액이 0 이 될 때까지 
            //현재 잔액 - 동전[고려중인 인덱스]>0
                //현재 잔액 -= 동전[고려중인 인덱스]
                //count++;
            
    }

}