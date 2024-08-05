import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static final int UNUSED = -1; 

    static int[][] map;
    static int[][] memo; 
    static int n; 

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(buffer.readLine());
        
        map = new int[n][n];
        memo = new int[n][n];

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0;y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken()); 
                memo[x][y] = UNUSED;
            }
        }


        System.out.println(getMinMax(0,0));
        


    }

    private static final int[] dx = {1,0};
    private static final int[] dy = {0,1};


    //[x][y]
    private static int getMinMax(int x, int y){
        if(x==n-1&&y==n-1){
            return memo[n-1][n-1] = map[n-1][n-1];
        }

        if(memo[x][y]!=UNUSED){
            return memo[x][y];
        }
        int result = 0; 

        for(int dir=0; dir<2; dir++){
            int nX = x+ dx[dir];
            int nY = y + dy[dir];

            if(inRange(nX, nY)){
                result = Math.max(
                         result, Math.min(map[nX][nY], getMinMax(nX,nY)));
            }
        }

        return memo[x][y] = result; 


    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<n&&y<n; 
    }

}