import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());
        int[] coins = new int[n+1];

        tokens = new StringTokenizer(buffer.readLine()); 
        for(int i=1; i<=n; i++){
            coins[i] = Integer.parseInt(tokens.nextToken());
        }

        int[][] d= new int[n+1][4];

        for(int i=0; i<=n; i++){
            Arrays.fill(d[i], -1);
        }

        d[0][0] = 0; 
        d[1][0] = 0; 
        d[1][1] = coins[1];

        for(int x=2; x<=n; x++){
            for(int y=0; y<=3; y++){
                if(d[x-2][y]!=-1){
                    d[x][y] = Math.max(d[x-2][y]+coins[x], d[x][y]);
                }

                if(y>=1&&d[x-1][y-1]!=-1){
                    d[x][y] = Math.max(d[x-1][y-1]+coins[x], d[x][y]);
                }
            }
        }
        int result = 0; 
        for(int y=0; y<=3; y++){
            result = Math.max(result, d[n][y]);
        }
        System.out.println(result); 
    }
}