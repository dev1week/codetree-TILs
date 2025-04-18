import java.io.*;
import java.util.*;


public class Main {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens; 

    

    static final int MAX_DIST = 1000*100000+1; 

    public static void main(String[] args) throws IOException{
        
        //N개의 장소 
            //N번은 학교 
        //M개의 간선 
        //방향성을 가지는 엣지 
        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken()); 
        final int START = n; 
        int m = Integer.parseInt(tokens.nextToken()); 

        //그래프를 만든다. 
        List<Node>[] graph = new List[n+1];
        for(int node=1; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int end = Integer.parseInt(tokens.nextToken());
            int start = Integer.parseInt(tokens.nextToken()); 
            int dist = Integer.parseInt(tokens.nextToken()); 

            graph[start].add(new Node(end, dist)); 
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist, MAX_DIST); 
        dist[START] = 0; 

        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        pq.add(new Node(START, 0)); 

        while(!pq.isEmpty()){
            Node current = pq.poll();


            if(current.dist != dist[current.idx]) continue; 


            for(Node next: graph[current.idx]){
                int newDist = dist[current.idx] + next.dist; 

                if(dist[next.idx]>newDist){
                    dist[next.idx] = newDist; 
                    pq.add(new Node(next.idx, newDist));
                }
            }
        }

        //System.out.println(Arrays.toString(dist)); 
        int result = 0; 
        for(int node=1; node<=n; node++){
            if(dist[node]!=MAX_DIST){
                result = Math.max(dist[node], result);
            }
        }

        System.out.println(result);

        //dist배열 중 학교-학교까지의 거리 제외하고 최대 거리 출력 


        //1. 간선의 연결 정보를 반대로 입력 받는다. 
        //2. 다익스트라로 학교로부터 모든 장소들로 가는 시간을 구한다. 
        //nlogm 
        //3. dist배열에서 최솟값을 구한다. 
        //n 
        

    }
}

class Node implements Comparable<Node>{
    int idx, dist; 


    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist; 
    }


    public int compareTo(Node o){
        return this.dist-o.dist;
    }

}