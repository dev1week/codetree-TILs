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
        prefixSum = new int[n+1][n+1]; 

        for(int x=1; x<=n; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=1; y<=n; y++){
                numbers[x][y] = Integer.parseInt(tokens.nextToken());
            }
        }


        //누적합을 만든다. 
        for(int x=1; x<=n; x++){
            for(int y=1; y<=n; y++){
                prefixSum[x][y] = prefixSum[x-1][y] + prefixSum[x][y-1] - prefixSum[x-1][y-1] + numbers[x][y];
            }
        }


        int result = 0; 
        //누적합으로 k*k 크기의 합을 구한다. 
        for(int startX=1; startX<=n-k+1; startX++){
            
            for(int startY=1; startY<=n-k+1; startY++){
                int endX = startX+k-1;
                int endY = startY+k-1; 

                result = Math.max(result, getPartSum(startX, startY, endX, endY, prefixSum));
            }
        }
        System.out.println(result);
    }

    private static int getPartSum(int startX, int startY, int endX, int endY, int[][] prefixSum){
        return prefixSum[endX][endY] - prefixSum[startX-1][endY] - prefixSum[endX][startY-1] + prefixSum[startX-1][startY-1];

    }


  
}