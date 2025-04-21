import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    private static final int MAX_DIST = (int) 10000*100000+1;

    public static void main(String[] args) throws IOException{
        
        tokens = new StringTokenizer(buffer.readLine()); 
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        tokens = new StringTokenizer(buffer.readLine()); 
        int a = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken());
        int c = Integer.parseInt(tokens.nextToken()); 



        List<Node>[] graph = new List[n+1]; 
        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken());
            int dist = Integer.parseInt(tokens.nextToken());

            graph[node1].add(new Node(node2, dist));
            graph[node2].add(new Node(node1, dist)); 

        }

        // System.out.println(MAX_DIST); 

        int[] aDist = getDist(a, graph, n); 
        int[] bDist = getDist(b, graph, n); 
        int[] cDist = getDist(c, graph, n); 

        // System.out.println(Arrays.toString(aDist)); 
        // System.out.println(Arrays.toString(bDist)); 
        // System.out.println(Arrays.toString(cDist)); 
        
        //a출발지에 대한 dist 배열 
        //b출발지에 대한 dist 배열 
        //c출발지에 대한 dist 배열 

        int maxDist = 0; 
        for(int node=1; node<=n; node++){
            if(isABC(node,a,b,c))continue; 
            
            
            int minDist = MAX_DIST;
            minDist = Math.min(aDist[node], minDist);
            minDist = Math.min(bDist[node], minDist);
            minDist = Math.min(cDist[node], minDist);

            //System.out.println(node+" "+minDist); 

            maxDist = Math.max(maxDist, minDist); 
        }

        System.out.println(maxDist); 

        //a,b,c를 제외한 모든 노드 순회 
            //a_dist, b_dist, c_dist 중 가장 가까운 거리 구함 
            //해당 거리가 최대인지 확인한다. 

        
    }

    private static int[] getDist(int start, List<Node>[] graph, int n){
        int[] dist = new int[n+1]; 

        Arrays.fill(dist, MAX_DIST); 
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        dist[start] = 0;
        pq.add(new Node(start, 0)); 

        while(!pq.isEmpty()){
            Node current = pq.poll(); 

            if(dist[current.idx]!=current.dist)continue; 

            for(Node next : graph[current.idx]){
                int newDist = dist[current.idx]  + next.dist;

                if(dist[next.idx]>newDist){
                    dist[next.idx] = newDist; 
                    pq.add(new Node(next.idx, newDist)); 
                }
            }
        }


        return dist; 
    }

    private static boolean isABC(int node, int a, int b, int c){
        return node==a||node==b||node==c;
    }

}

class Node implements Comparable<Node>{
    int idx, dist; 

    public Node(int idx, int dist){
        this.idx = idx; 
        this.dist = dist; 
    }

    public int compareTo(Node o){
        return this.dist - o.dist; 
    }
}