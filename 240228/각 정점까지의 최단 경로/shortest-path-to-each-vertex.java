import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int idx;
    int dist;


    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }


    @Override
    public int compareTo(Node o){
        return this.dist - o.dist;
    }

    @Override
    public String toString(){
        return this.dist+"->"+this.idx;
    }

}

public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer tokens;

    static int[] dist;
    static List<Node>[] graph;
    static PriorityQueue<Node> que;

    static int n;
    static int m;
    static int k;

    public static void main(String[] args)throws IOException{

        init();

        //출발지를 등록합니다.
        dist[k] = 0;
        que.add(new Node(k, 0));

        //다익스트라 알고리즘 실행
        while(!que.isEmpty()){
            Node cur = que.poll();
            //같은 정점의 원소가 여러번 들어가는 문제를 방지하기 위해
            //minDist가 최신 dist[minIdx]값과 다르면 패스합니다.

            if(cur.dist!=dist[cur.idx]){

                continue;
            }

            for(Node neighbor: graph[cur.idx]){

                int newDist = dist[cur.idx] + neighbor.dist;

                if(dist[neighbor.idx]> newDist){
                    dist[neighbor.idx] = newDist;
                    que.add(new Node(neighbor.idx, newDist));
                }
            }
        }


        print();

    }


    static void init() throws IOException{

        tokens = new StringTokenizer(buffer.readLine());

        n = Integer.valueOf(tokens.nextToken());
        m = Integer.valueOf(tokens.nextToken());
        k = Integer.valueOf(buffer.readLine());

        graph = new ArrayList[n+1];
        dist = new int[n+1];
        que = new PriorityQueue<>();

        for(int i=0; i<=n; i++){
            dist[i] = (int)1e9;
        }

        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>();
        }

        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine());
            int start = Integer.valueOf(tokens.nextToken());
            int end = Integer.valueOf(tokens.nextToken());
            int dist = Integer.valueOf(tokens.nextToken());

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }

    }

    static void print(){
        StringBuilder result= new StringBuilder();
        for(int idx=1; idx<=n; idx++){
            if(dist[idx]==(int)1e9){
                result.append(-1).append("\n");
            }else{
                result.append(dist[idx]).append("\n");
            }
        }
        System.out.println(result); 
    }
}