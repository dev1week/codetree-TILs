import java.io.*;
import java.util.*; 

class Meet implements Comparable<Meet>{
    int s, e;

    public Meet(int s, int e){
        this.s = s;
        this.e = e; 
    }

    @Override
    public int compareTo(Meet o){
        return this.e - o.e; 
    }

    @Override
    public String toString(){
        return this.s+"~"+this.e; 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        Meet[] meets = new Meet[n]; 

        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int start = Integer.parseInt(tokens.nextToken()); 
            int end = Integer.parseInt(tokens.nextToken()); 

            meets[i] = new Meet(start, end); 
        }

        Arrays.sort(meets);

        int currentEnd = 0;
        int cnt = 0; 
        for(Meet meet : meets){
            if(currentEnd<=meet.s){
                //System.out.println(meet);
                cnt++;
                currentEnd = meet.e;
            }
        }

        System.out.println(cnt);
    }
}