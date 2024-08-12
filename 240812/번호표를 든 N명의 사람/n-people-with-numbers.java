import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{
        // 무대에 최대로 올라갈 수 있는 사람 k를 임의로 정해봅니다. (-> 최솟값)
            //무대에 최대로 올라갈 수 있는 사람 수(k)와 각자 무대에서 체류하는 시간(d[])를 이용해 총 시간을 구합니다.
                //k명까지 우선순위큐에 바로 넣습니다. 
                //k번째 이후 사람부터 n명까지의 사람을 순회합니다. 
                    //우선 순위큐에서 빠질 사람을 구합니다. 
                    //우선 순위큐에 빠질 사람의 종료시간 + 현재 사람의 소요 시간을 구해 최종 종료시간을 구하고 우선순위 큐에 넣습니다. 

                //우선순위 큐를 모두 비우면서 가장 마지막 종료시간을 찾습니다. 

                //해당 종료시간 <=Tmax 인지 확인합니다. 

        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken());
        int tMax = Integer.parseInt(tokens.nextToken()); 

        long[] d = new long[n];

        for(int i=0; i<n; i++){
            d[i] = Long.parseLong(buffer.readLine()); 
        }

        int l = 0;
        int h = n; 

        while(h>l){
            int mid = (l+h)/2;

            if(isValid(mid, d, tMax, n)){
                h = mid; 
            }else{
                l = mid+1; 
            }
        }

        System.out.println(l); 
    }

    private static boolean isValid(int mid, long[] d, int tMax, int n){
        PriorityQueue<Long> que = new PriorityQueue<>(); 

        for(int i=0; i<mid; i++){
            que.add(d[i]);
        }

        for(int i=mid; i<n; i++){
            long currentTime = que.poll(); 

            que.add(d[i]+currentTime);
        }

        long lastEndTime = 0; 

        while(!que.isEmpty()){
            lastEndTime = Math.max(lastEndTime, que.poll());
        }

        return lastEndTime<=tMax; 
    }
}