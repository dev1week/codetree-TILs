import java.io.*;
import java.util.*; 

class Task{
    int start, end, reward; 

    public Task(int start, int end, int reward){
        this.start = start;
        this.end = end;
        this.reward = reward;
    }
}
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;



    public static void main(String[] args)throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        Task[] tasks = new Task[n]; 
        int[] d = new int[n];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            int reward = Integer.parseInt(tokens.nextToken());
            tasks[i] = new Task(start, end, reward);
            d[i] = reward; 
        }

        //D[I] I번째 테스크를 마지막으로 실행할 때 최대 리워드 

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(tasks[i].start>tasks[j].end){
                    d[i] = Math.max(d[i], d[j]+tasks[i].reward);
                }
            }
        }

        int result = 0; 
        for(int i=0; i<n; i++){
            result = Math.max(result, d[i]);
        }

        System.out.println(result); 


    }
}