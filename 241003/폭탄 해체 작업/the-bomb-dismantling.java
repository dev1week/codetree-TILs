import java.io.*;
import java.util.*; 
class Bomb implements Comparable<Bomb>{
    int limit, score;

    public Bomb(int limit, int score){
        this.limit = limit;
        this.score = score; 
    }

    public int compareTo(Bomb o){
        if(this.limit == o.limit){
            return o.score-this.score; 
        }

        return this.limit-o.limit;
    }

    public String toString(){
        return this.score+":"+this.limit;
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        PriorityQueue<Bomb> pq = new PriorityQueue<>(); 

        for(int i=0; i<n; i++){
            tokens= new StringTokenizer(buffer.readLine()); 

            int score = Integer.parseInt(tokens.nextToken());
            int limit = Integer.parseInt(tokens.nextToken()); 

            pq.add(new Bomb(limit, score)); 
        }

        int currentTime = 0; 
        int totScore = 0; 
        while(!pq.isEmpty()){
            Bomb candiate = pq.poll();
            if(currentTime<candiate.limit){
                //System.out.println(candiate+" "+currentTime); 
                totScore += candiate.score; 
                currentTime ++;
            }
        }

        System.out.println(totScore); 

        
    }
}