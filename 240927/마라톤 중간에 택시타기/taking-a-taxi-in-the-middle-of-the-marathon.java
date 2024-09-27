import java.io.*;
import java.util.*; 

class Point{
    int x, y;


    public Point(int x, int y){
        this.x= x;
        this.y = y; 
    }


    public int getDistance(Point o){
        return Math.abs(o.x - this.x)+ Math.abs(o.y-this.y); 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        Point[] points = new Point[n]; 
        int[] l = new int[n];
        int[] r = new int[n];

        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine());

            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());

            points[i] = new Point(x,y); 
        }

        for(int i=1; i<n; i++){
            int dist = points[i-1].getDistance(points[i]);
            l[i] = dist+l[i-1]; 
        }

        for(int i=n-2; i>=0; i--){
            int dist = points[i+1].getDistance(points[i]);
            r[i] = dist + r[i+1]; 
        }

        int min = Integer.MAX_VALUE; 

        //System.out.println(Arrays.toString(r));
        //System.out.println(Arrays.toString(l));
        for(int exceptPoint = 1; exceptPoint<n-1; exceptPoint++){
            int dist = l[exceptPoint-1] + r[exceptPoint+1];

            int test1 = points[exceptPoint-1].getDistance(points[exceptPoint+1]);
            
            
            min = Math.min(dist+test1, min); 
        }

        System.out.println(min);
    }
}