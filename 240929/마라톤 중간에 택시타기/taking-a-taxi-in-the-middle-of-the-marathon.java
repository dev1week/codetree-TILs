import java.io.*;
import java.util.*; 

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getDist(Point o){

        return Math.abs(o.x-this.x) + Math.abs(o.y-this.y); 

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

            l[i] = l[i-1] + points[i].getDist(points[i-1]);

        }

        for(int i=n-2; i>=0; i--){
            r[i] = r[i+1] + points[i].getDist(points[i+1]);
        }

        int result = Integer.MAX_VALUE; 
        for(int except =1; except<n-1; except++){
            int newDist = l[except-1] + r[except+1] + points[except-1].getDist(points[except+1]);
            
            result=Math.min(result, newDist);
        }

        System.out.println(result);
    
    }
}