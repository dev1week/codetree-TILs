import java.io.*;
import java.util.*; 
class Line implements Comparable<Line>{
    int s, e;

    public Line(int s, int e){
        this.s = s;
        this.e = e; 
    }

    public int compareTo(Line o){
        if(this.e==o.e){
            return this.s-o.s;
        }

        return this.e-o.e; 
    } 
    public String toString(){
        return this.s+"~"+this.e;
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        //d[i] = i번째 선분까지 고려했을 때 겹치지 않게 가장 많은 수의 선분을 고르는 경우의 수 

        int n = Integer.parseInt(buffer.readLine());

        Line[] lines = new Line[n+1]; 
        
        int[] dp = new int[n+1]; 
        
        for(int i=1; i<=n; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int s = Integer.valueOf(tokens.nextToken());
            int e = Integer.valueOf(tokens.nextToken()); 

            lines[i] = new Line(s, e); 
        }
        lines[0] = new Line(0,0);
        Arrays.sort(lines); 

        for(int current=0; current<=n; current++){
            for(int prev=0; prev<current; prev++){
                if(lines[prev].e<lines[current].s){
                    dp[current] = Math.max(dp[current], dp[prev]+1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt()); 
        //System.out.println(Arrays.toString(dp)); 
        
    }
}