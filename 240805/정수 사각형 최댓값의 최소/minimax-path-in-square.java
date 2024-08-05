import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        int[][] map = new int[n][n];
        int[][] d = new int[n][n];

        //d[i][j] 11에서 시작. 오른쪽, 밑으로만 이동하여 거쳐간 위치 중 최대값 중 최소 
        //min( max(d[i][j-1], arr[i][j]), max(d[i-1][j], arr[i][j]))

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken());
            }
        }


        d[0][0] = map[0][0];

        for(int x=1; x<n; x++){
            d[x][0] = Math.max(d[x-1][0], map[x][0]);
        }

        for(int y=1; y<n; y++){
            d[0][y] = Math.max(d[0][y-1], map[0][y]);
        }

        for(int x=1; x<n; x++){
            for(int y=1; y<n; y++){
                d[x][y] = Math.min(Math.max(d[x][y-1], map[x][y]), Math.max(d[x-1][y], map[x][y]));
            }
        }

        System.out.println(d[n-1][n-1]); 


    }
}