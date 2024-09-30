import java.io.*;
import java.util.*; 
import java.util.stream.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        int n = Integer.parseInt(buffer.readLine()); 

        //주어진 숫자를 우선순위 큐에 넣는다. 

        PriorityQueue<Integer> pq = Arrays.stream(buffer.readLine().split("\\s++"))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toCollection(PriorityQueue::new)); 


        // System.out.println(pq);
        int totCost = 0;
        while(pq.size()!=1){
            int num1 = pq.poll();
            int num2 = pq.poll(); 

            int cost = num1+num2; 
            totCost += cost; 

            pq.add(cost);
        }

        System.out.println(totCost); 
        //큐의 크기가 하나가 될 떄까지 반복한다. 
            //합치는 비용을 계산한다. 
            //합치는 비용의 총합을 구한다. 
            //합치는 비용을 큐에 넣는다. 

    }
}