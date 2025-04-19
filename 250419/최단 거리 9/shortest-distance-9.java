import java.io.*;
import java.util.*; 
public class Main {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens; 

    private static final int MAX_DIST = (int) 10e8+1; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        List<Node>[] graph = new List[n+1];
        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }


        //간선 정보를 채워넣는다. (양방향)
        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 
            int node1 = Integer.parseInt(tokens.nextToken()); 
            int node2 = Integer.parseInt(tokens.nextToken()); 
            int dist = Integer.parseInt(tokens.nextToken()); 

            graph[node1].add(new Node(node2, dist));
            graph[node2].add(new Node(node1, dist));
            
        }

        tokens = new StringTokenizer(buffer.readLine()); 

        final int START = Integer.parseInt(tokens.nextToken()); 
        final int END = Integer.parseInt(tokens.nextToken());

        int[] dist = new int[n+1]; 
        int[] route = new int[n+1]; 

        Arrays.fill(dist, MAX_DIST); 
        dist[START] = 0; 

        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        pq.add(new Node(START, 0)); 

        while(!pq.isEmpty()){
            //System.out.println(pq);
            Node current = pq.poll();

            if(current.dist != dist[current.idx]) continue; 

            for(Node next : graph[current.idx]){
                
                int newDist = dist[current.idx] + next.dist; 

                if(newDist<dist[next.idx]){
                    dist[next.idx] = newDist; 
                    route[next.idx] = current.idx; 
                    pq.add(new Node(next.idx, newDist));
                }
            }            
        }


        int currentNode = END; 
        List<Integer> reverseRoute = new ArrayList<>(); 
        while(currentNode != START){
            reverseRoute.add(currentNode); 
            currentNode = route[currentNode]; 
        }
        reverseRoute.add(START); 

        StringBuilder result = new StringBuilder(); 

        result.append(dist[END]).append("\n"); 
        for(int i=reverseRoute.size()-1; i>=0; i--){
            result.append(reverseRoute.get(i)).append(" ");
        }

        System.out.println(result);

        




        //다익스트라 알고리즘을 이용해 dist 배열을 채운다. 
            //dist 배열 갱신 시 routes[도착] = 출발 형태로 채운다. 


        //도착지부터 시작해서 출발지까지 재귀로 호출하여 리스트에 넣는다. 

        //리스트를 역으로 출력한다. 

        
        // Please write your code here.
    }
}

class Node implements Comparable<Node>{
    int idx, dist;


    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist; 
    }

    @Override 
    public int compareTo(Node o){
        return this.dist - o.dist;
    }

    public String toString(){
        return this.dist +"->"+this.idx;
    }

}