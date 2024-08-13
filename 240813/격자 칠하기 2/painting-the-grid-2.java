import java.io.*;
import java.util.*;

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y; 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        
        //0~1000000중에서 최솟값 이진 탐색으로 
            //bfs 수행하여 몇개 칸을 갈 수 있는지 확인하기 
        int n = Integer.parseInt(buffer.readLine()); 

        int[][] map = new int[n][n]; 
        int maxNum = 0;
        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken()); 
                maxNum = Math.max(maxNum, map[x][y]);
            }
        }    

        int l = 0;
        int h = maxNum; 

        while(h>l){
            int mid =(l+h)/2; 

            if(isValid(mid, n, map)){
                h = mid;
            }else{
                l = mid+1; 
            }

        }

        System.out.println(l);
    }

    private static int getCount(int startX, int startY, int[][] map, int n, int mid){
        int cnt = 0; 

        boolean[][] isVisited = new boolean[n][n]; 

        Queue<Point> que = new LinkedList<>(); 

        que.add(new Point(startX, startY));
        isVisited[startX][startY] = true; 


        while(!que.isEmpty()){
            cnt++;
            Point current = que.poll(); 

            for(int d=0; d<4; d++){
                int nX = current.x+dx[d];
                int nY = current.y+dy[d]; 

                if(isValid(nX,nY,n)&&Math.abs(map[current.x][current.y]-map[nX][nY])<=mid&&!isVisited[nX][nY]){
                    isVisited[nX][nY] = true; 
                    que.add(new Point(nX, nY)); 
                }
            }

        }
        return cnt;

    }

    private static boolean isValid(int x, int y, int n){
        return x>=0&&y>=0&&x<n&&y<n; 
    }

    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    private static boolean isValid(int mid, int n, int[][] map){
        
        int result = 0; 
        //시작칸 지정하기 
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                //해당 시작칸에서 최대 몇칸까지 칠할 수 있는지 판단하기         
                result = Math.max(getCount(x,y, map,n, mid), result);
                //System.out.println(mid+" "+result); 
            }
        }

        return result*2>=n*n;


    }
}