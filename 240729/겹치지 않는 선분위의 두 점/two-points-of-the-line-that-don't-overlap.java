import java.io.*;
import java.util.*; 

class Line implements Comparable<Line>{
    long start, end;

    public Line(long start, long end){
        this.start = start;
        this.end = end; 
    }

    @Override
    public int compareTo(Line o){
        if(this.start == o.start){
            return this.end>o.end ? 1: -1; 
        }else{
            return this.start>o.end? 1:-1; 
        }
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;


    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        Line[] lines = new Line[m];

        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(buffer.readLine()); 
            lines[i] = new Line(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
        }

        Arrays.sort(lines);

        long l = 0;
        long h = (long) 1e18;

        while(h>l){
            long mid = (h+l+1)/2; 

            if(isValid(mid, lines, n)){
                l = mid; 
            }else{
                h = mid-1; 
            }
        }

        System.out.println(l);
    }
    private static boolean isValid(long mid, Line[] lines, int n){
        long lastPosition = lines[0].start; 
        int cnt = 1; 
        for(int i=0; i<lines.length; i++){
            Line line = lines[i];
            while(lastPosition+mid <=line.end){
                cnt++;
                lastPosition = Math.max(line.start, lastPosition+mid);
            }
            if(cnt>=n){
                return true; 
            }
        }

        return cnt>=n; 
    }
}