import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        

        int n = Integer.parseInt(buffer.readLine()); 
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];;

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                a[x][y] = Integer.parseInt(tokens.nextToken()); 
            }
        }

        d[0][n-1] = a[0][n-1];
        for(int x=1; x<n; x++){
            d[x][n-1] = d[x-1][n-1] + a[x][n-1];
        }

        
        for(int y=n-2; y>=0; y--){
            d[0][y] = d[0][y+1] + a[0][y];
        }

        for(int x=1; x<n; x++){
            for(int y=n-2; y>=0; y--){
                d[x][y] = Math.min(d[x-1][y], d[x][y+1]) + a[x][y];
            }
        }
        System.out.println(d[n-1][0]); 

    }

    private static String print(int[][] map){
        StringBuilder sb = new StringBuilder();

        for(int[] ma: map){
            for(int m : ma){
                sb.append(m);
            }sb.append("\n");
        }
        return sb.toString(); 
    }
}