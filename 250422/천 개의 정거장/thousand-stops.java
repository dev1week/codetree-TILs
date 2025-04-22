import java.util.*;
import java.io.*; 

public class Main {

    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens; 
    private static final int NODE_NUM = 1001;
    private static final long MAX_COST = Long.MAX_VALUE;
    private static final int MAX_TIME = 1001;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int a = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken()); 
        int n = Integer.parseInt(tokens.nextToken()); 

        List<Node>[] graph = new List[NODE_NUM]; 
        for(int node=0; node<NODE_NUM; node++){
            graph[node]= new ArrayList<>();
        }

        for(int busId=1; busId<=n; busId++){
            tokens = new StringTokenizer(buffer.readLine());
            long cost = Long.parseLong(tokens.nextToken());
            int stopNum = Integer.parseInt(tokens.nextToken()); 

            int[] stops = Arrays.stream(buffer.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();

            for(int stop=1; stop<stopNum; stop++){
                graph[stops[stop-1]].add(new Node(busId, 1, stops[stop], cost));
            }
        }
        int[] minTime = new int[NODE_NUM];
        Arrays.fill(minTime, MAX_TIME);
        minTime[a]=0;
        long[] minCost = new long[NODE_NUM];
        Arrays.fill(minCost, MAX_COST);
        minCost[a]=0;
        int[] busIds = new int[NODE_NUM]; 

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,a,0)); 

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(minCost[current.node]!=current.cost)continue;

            for(Node next: graph[current.node]){
                long newCost = current.cost;
                if(next.busId!=current.busId){
                    newCost +=next.cost;
                }
                int newTime = next.time+minTime[current.node];

                if(newCost<minCost[next.node]){
                    minCost[next.node]= newCost;
                    minTime[next.node]=newTime;
                    pq.add(new Node(next.busId,newTime,next.node,newCost));
                }

                //버스를 갈아탔을 경우 -> 예산 추가 
                //시간 1증가 

            }
        }
        StringBuilder result = new StringBuilder();   
        result.append(minCost[b]==MAX_COST?-1:minCost[b]).append(" ").append(minTime[b]==MAX_TIME?-1:minTime[b]);
        System.out.println(result);
    }
}

class Node implements Comparable<Node>{
    int busId, time, node;
    long cost; 

    public Node(int busId, int time, int node, long cost){
        this.busId=busId;
        this.time = time;
        this.node = node;
        this.cost = cost;
    }

    public int compareTo(Node o){
        if(this.cost==o.cost){
            return this.time-o.time;
        }
        return Long.compare(this.cost, o.cost);
    }

    public String toString(){
        return cost+"->"+node+ " "+busId+"번 버스";
    }
}