import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

   
    static int[][] map; 
    static final int USUSED = -1; 
    static int n;
    static int m; 


  

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());

        map = new int[n][m];
        int[][] d = new int[n][m]; 
 

        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<m; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken());
                d[x][y] = -1; 
            }

        }
        d[0][0]=1; 

    

        
        for(int x=1; x<n; x++){
            for(int y=1; y<m; y++){
                for(int prevX=0; prevX<x; prevX++){
                    for(int prevY=0; prevY<y; prevY++){
                        if(d[prevX][prevY]==-1) continue; 
                        if(map[x][y]>map[prevX][prevY]){
                            d[x][y] = Math.max(d[x][y], d[prevX][prevY]+1);
                        }
                    }
                }
            }
        }
        int result = 0; 
        for(int x=0; x<n; x++){
            //System.out.println(Arrays.toString(d[x])); 
            for(int y=0; y<m; y++){
                result = Math.max(result, d[x][y]);
            }
        }
        System.out.println(result); 
    }
}