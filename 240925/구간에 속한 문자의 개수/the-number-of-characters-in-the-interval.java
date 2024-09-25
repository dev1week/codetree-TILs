import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static final int a = 0;
    static final int b = 1;
    static final int c = 2; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken()); 

        int[][][] cnt = new int[n+1][m+1][3]; 
        int[][][] prefixSum = new int[n+1][m+1][3]; 

        for(int x=1; x<=n; x++){
            String line = buffer.readLine(); 
            for(int y=1; y<=m; y++){
                char data = line.charAt(y-1); 
                
                if(data=='a'){
                    cnt[x][y][a]++;
                }else if(data=='b'){
                    cnt[x][y][b]++;
                }else if(data=='c'){
                    cnt[x][y][c]++;
                }

                prefixSum[x][y][a] = prefixSum[x-1][y][a] + prefixSum[x][y-1][a] + cnt[x][y][a]-prefixSum[x-1][y-1][a];
            
                prefixSum[x][y][b] = prefixSum[x-1][y][b] + prefixSum[x][y-1][b] + cnt[x][y][b]-prefixSum[x-1][y-1][b];;
            
                prefixSum[x][y][c] = prefixSum[x-1][y][c] + prefixSum[x][y-1][c] + cnt[x][y][c]-prefixSum[x-1][y-1][c];;
            }
        }


        


        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<k; query++){
            tokens = new StringTokenizer(buffer.readLine());
            int startX = Integer.parseInt(tokens.nextToken());
            int startY = Integer.parseInt(tokens.nextToken());
            int endX = Integer.parseInt(tokens.nextToken()); 
            int endY = Integer.parseInt(tokens.nextToken()); 

            int aCnt = getCnt(startX, startY, endX, endY, a, prefixSum);
            int bCnt = getCnt(startX, startY, endX, endY, b, prefixSum);
            int cCnt = getCnt(startX, startY, endX, endY, c, prefixSum);
            result.append(aCnt+" "+bCnt+" "+cCnt).append("\n");
        }


        System.out.println(result); 
        
        
    }

    private static int getCnt(int startX, int startY, int endX, int endY, int alphabet, int[][][] prefixSum){
        return prefixSum[endX][endY][alphabet] - prefixSum[startX-1][endY][alphabet] - prefixSum[endX][startY-1][alphabet] + prefixSum[startX-1][startY-1][alphabet];

    }
}