import java.io.*; 
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        int[][] map = new int[n][n];
        int[][] sum = new int[n][n]; 

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken());
            }
        }

        sum[0][0] = map[0][0]; 

        for(int y=1; y<n; y++){
            sum[0][y] = map[0][y] + sum[0][y-1];
        }

        for(int x=1; x<n; x++){
            sum[x][0] = map[x][0] + sum[x-1][0];
        }


        for(int x=1; x<n; x++){
            for(int y=1; y<n; y++){
                sum[x][y] = map[x][y];
                sum[x][y] += Math.max(sum[x-1][y], sum[x][y-1]);
            }
        }

        System.out.println(sum[n-1][n-1]); 

    }
}