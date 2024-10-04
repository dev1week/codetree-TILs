import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m]; 

        for(int x=0;x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<m; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken()); 
            }
        }

        dp[0][0] = 1; 

        for(int currentX=1; currentX<n; currentX++){
            for(int currentY=1; currentY<m; currentY++){
                for(int prevX=0; prevX<currentX; prevX++){
                    for(int prevY=0; prevY<currentY; prevY++){
                        if(dp[prevX][prevY]==0)continue; 
                        if(map[prevX][prevY]<map[currentX][currentY]){
                            dp[currentX][currentY] = Math.max(dp[currentX][currentY], dp[prevX][prevY]+1);
                        }
                    }
                }
            }
        }
        //print(dp); 

        int result = 0 ; 
        for(int x=0; x<n; x++){
            for(int y=0; y<m; y++){
                result = Math.max(result, dp[x][y]);
            }
        }

        System.out.println(result); 


    }

    private static void print(int[][] map){
        for(int[] ma: map){
            for(int m : ma){
                System.out.print(m);
            }System.out.println(); 
        }
    }
}