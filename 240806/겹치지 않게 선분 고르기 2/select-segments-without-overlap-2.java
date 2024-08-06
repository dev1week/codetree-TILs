import java.io.*;
import java.util.*; 

class Line implements Comparable<Line>{
    int start, end;

    public Line(int start, int end){
        this.start = start;
        this.end = end; 
    }

    @Override
    public int compareTo(Line o){
        return this.start - o.start; 
    }

    public String toString(){
        return this.start+"-"+this.end; 
    }

}

public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        Line[] lines = new Line[n]; 

        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine());
            
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken()); 

            lines[i] = new Line(start, end); 
        }
        int[]d = new int[n];
        d[0] = 1; 

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                //System.out.println(lines[i]);
                //System.out.println(lines[j]);
                if(lines[i].start > lines[j].end){
                    d[i] = Math.max(d[j]+1, d[i]);
                }
            }
        }

        //System.out.println(Arrays.toString(d)); 

        System.out.println(Arrays.stream(d).max().getAsInt()); 

    }
}