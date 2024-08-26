import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static int[] costTime; 
    static int n;
    static int timeLimit; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(tokens.nextToken());
        timeLimit = Integer.parseInt(tokens.nextToken());

        costTime = new int[n]; 

        for(int i=0; i<n; i++){
            costTime[i] = Integer.parseInt(buffer.readLine()); 
        }


        int l = 1;
        int h = n; 


        while(h>l){
            int mid = (l+h)/2;

            if(isValid(mid)){
                h = mid; 
            }else{
                l = mid+1; 
            }
        }

        System.out.println(l);


    }

    private static boolean isValid(int mid){
        PriorityQueue<Integer> que = new PriorityQueue<>(); 

        for(int i=0; i<mid; i++){
            que.add(costTime[i]);
        }

        for(int i=mid; i<n; i++){
            int endTime = que.poll();
            que.add(endTime+costTime[i]); 
        }


        int result = 0; 
        while(!que.isEmpty())
        {
            result = Math.max(result, que.poll());
        }

        return result<=timeLimit; 

    }
}