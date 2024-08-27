import java.io.*;
import java.util.*; 
class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y; 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    static int n; 
    static int[][] map; 
    static int limit; 

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(buffer.readLine()); 

        map = new int[n][n];


        int max = 0; 
        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken());
                max = Math.max(max, map[x][y]);
            }
        }

        if(n%2==0){
            limit = n*n/2; 
        }else{
            limit = n*n/2+1; 
        }

        int l = 0;
        int h = max; 

        while(h>l){
            int mid = (l+h)/2; 

            if(isValid(mid)){
                h = mid;
            }else{
                l = mid+1; 
            }
        }

        System.out.println(l); 
    }
    private static boolean isValid(int mid){
        //시작점 설정하기 
            //bfs 시도하여 최대 몇칸을 색칠하는지 
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                int count = bfs(x,y,mid);
                // System.out.println(x+";"+y);
                // System.out.println(mid+" "+count);
                if(count>=limit){
                    return true; 
                }
            }
        }
        return false; 
    }

    private static int bfs(int startX, int startY, int mid){
        int count = 1; 
        Queue<Point> que = new LinkedList<>(); 
        boolean[][] isVisited = new boolean[n][n]; 
        isVisited[startX][startY] = true;
        que.add(new Point(startX, startY));


        while(!que.isEmpty()){
            Point current = que.poll();

            for(int dir=0; dir<4; dir++){
                int nX = current.x + dx[dir];
                int nY = current.y + dy[dir];

                if(isRange(nX, nY)&&isValid(nX, nY, current, mid)&&!isVisited[nX][nY]){
                    que.add(new Point(nX, nY));
                    isVisited[nX][nY] = true; 
                    count++;
                    if(count>=limit){
                        return count; 
                    }
                }
            }
        }

        return count; 
    }

    private static boolean isRange(int x, int y){
        return x>=0&&y>=0&&x<n&&y<n; 
    }

    private static boolean isValid(int nX, int nY, Point current, int mid){
        return Math.abs(map[nX][nY]-map[current.x][current.y])<=mid; 
    }

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
}