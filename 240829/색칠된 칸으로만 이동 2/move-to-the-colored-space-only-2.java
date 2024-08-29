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

    static int m; 
    static int n; 

    static long[][] map;
    static int[][] isColored; 
    static final int YES = 1; 

    static final int dx[] = {-1,1,0,0};
    static final int dy[] = {0,0,-1,1};

    
    static List<Point> selecteds; 


    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        m = Integer.parseInt(tokens.nextToken());
        n = Integer.parseInt(tokens.nextToken()); 

        map = new long[m][n]; 
        isColored = new int[m][n]; 
        selecteds = new ArrayList<>();

        long max = 0; 
        for(int x=0; x<m; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                map[x][y] = Long.parseLong(tokens.nextToken()); 
                max = Math.max(max, map[x][y]);
            }
        }

        for(int x=0; x<m; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                isColored[x][y] = Integer.parseInt(tokens.nextToken()); 
                if(isColored[x][y]==YES){
                    selecteds.add(new Point(x,y)); 
                }
            }
        }


        long l = 0;
        long h = max; 

        while(h>l){
            long mid = (h+l)/2; 

            if(isValid(mid)){
                h = mid; 
            }else{
                l = mid+1; 
            }
        }

        System.out.println(l);
    }

    private static boolean isValid(long mid){
        boolean[][] isVisited = new boolean[m][n]; 
        Queue<Point> que = new LinkedList<>(); 
        que.add(selecteds.get(0)); 
        isVisited[selecteds.get(0).x][selecteds.get(0).y] = true; 


        while(!que.isEmpty()){
            Point cur = que.poll(); 

            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir]; 

                if(inRange(nx,ny)&&isValid(nx, ny, cur, mid, isVisited)){
                    isVisited[nx][ny] = true; 
                    que.add(new Point(nx, ny));
                }
            }
        }

        for(Point selected : selecteds){
            if(!isVisited[selected.x][selected.y])return false;
        }

        return true; 
    }

    private static boolean isValid(int nx, int ny, Point cur, long mid, boolean[][] isVisited){
        return !isVisited[nx][ny]&&Math.abs(map[nx][ny]-map[cur.x][cur.y])<=mid;
    }

    private static boolean inRange(int x, int y){
        return x>=0&&x<m&&y>=0&&y<n; 
    }
}