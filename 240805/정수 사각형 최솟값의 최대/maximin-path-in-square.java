import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        int[][] arr = new int[n][n];
        int[][] d = new int[n][n]; 

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                arr[x][y] = Integer.parseInt(tokens.nextToken());
            }
        }

        d[0][0] = arr[0][0];
        for(int x=1; x<n; x++){
            d[x][0] = Math.min(d[x-1][0], arr[x][0]);
        }

        for(int y=1; y<n; y++){
            d[0][y] = Math.min(d[0][y-1], arr[0][y]); 
        }

        for(int x=1; x<n; x++){
            for(int y=1; y<n; y++){
                d[x][y] = Math.max(Math.min(d[x-1][y], arr[x][y]), Math.min(d[x][y-1], arr[x][y]));
            }
        }
 
        System.out.println(d[n-1][n-1]);
    }


    private static String print(int[][] arr){
        StringBuilder sb = new StringBuilder(); 

        for(int[] ar: arr){
            for(int a: ar){
                sb.append(a);
            }sb.append("\n"); 
        }

        return sb.toString(); 
    }
}