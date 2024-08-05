import java.io.*;
import java.util.*; 

class Cell implements Comparable<Cell>{
    int x,y,num;

    public Cell(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Cell o){
        return this.num - o.num; 
    }

    @Override
    public String toString(){
        return this.x+":"+this.y+" = "+this.num; 
    }

}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        int[][] map = new int[n][n];
        int[][] d = new int[n][n];
        List<Cell> cells = new ArrayList<>(); 
        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<n; y++){
                map[x][y] = Integer.parseInt(tokens.nextToken()); 
                d[x][y] = 1; 
                cells.add(new Cell(x,y,map[x][y]));
            }
        }

        for(Cell cell : cells){

            for(int dir=0; dir<4; dir++){
                int nX = cell.x + dx[dir];
                int nY = cell.y + dy[dir];

                if(isValid(nX, nY, n) &&map[nX][nY]>map[cell.x][cell.y]){
                    d[nX][nY] = Math.max(d[cell.x][cell.y]+1, d[nX][nY]) ; 
                }
            }
        }

        int result = 0; 
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                result = Math.max(result, d[x][y]); 
            }
        }
        System.out.println(result); 

    }

    private static boolean isValid(int x, int y, int n){
        return x>=0&&y>=0&&x<n&&y<n; 

    }

    private static String print(int[][] arr){
        StringBuilder result = new StringBuilder();


        for(int[] ar: arr){
            for(int a: ar){
                result.append(a);
            }result.append("\n");
        }

        return result.toString(); 
    }
}