import java.io.*;
import java.util.*; 

class Quest{
    int exp, cost;


    public Quest(int exp, int cost){
        this.exp = exp;
        this.cost = cost; 
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        
        Quest[] quests = new Quest[n];


        int totTime =0; 
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int exp = Integer.parseInt(tokens.nextToken()); 
            int cost = Integer.parseInt(tokens.nextToken());
            quests[i] = new Quest(exp, cost); 
            totTime += quests[i].cost; 
        }

        int[] d = new int[totTime+1]; 
        //d[i] 현재 시간이 t일 때 얻을 수 있는 최대 경험치 수 
        
        Arrays.fill(d,-1);
        d[0] =0;

        for(Quest quest: quests){
            for(int time=totTime; time>=0; time--){
                if(time-quest.cost<0)continue; 
                if(d[time-quest.cost]==-1)continue; 
                d[time] = Math.max(d[time], d[time-quest.cost]+quest.exp);
            }
        }

        //System.out.println(Arrays.toString(d)); 

        int result = 0; 
        for(int time=1; time<=totTime; time++){
            if(d[time]>=m){
                result = time; 
                break;
            }    
        }
        System.out.println(result); 
    }
}