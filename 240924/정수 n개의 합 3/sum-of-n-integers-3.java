import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static int[][] numbers; 
    static int[][] prefixSum; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken()); 
        int k = Integer.parseInt(tokens.nextToken()); 

        numbers = new int[n+1][n+1];
        prefixSum= new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int j=1; j<=n; j++){
                numbers[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + numbers[i][j];
             }
        }

        int result = 0;

        for(int x=1; x<=n-k+1; x++){
            for(int y=1; y<=n-k+1; y++){
                result = Math.max(result, getPartSum(x,y,x+k-1,y+k-1));
            }
        }

        System.out.println(result);
    }


    private static int getPartSum(int startX, int startY, int endX, int endY){

        return prefixSum[endX][endY] - prefixSum[startX-1][endY] - prefixSum[endX][startY-1] + prefixSum[startX-1][startY-1];

    }
}