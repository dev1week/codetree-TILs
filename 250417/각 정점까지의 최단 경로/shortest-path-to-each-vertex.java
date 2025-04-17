import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    private static final int MAX_DIST = 300001; 


    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken()); 
        int m = Integer.parseInt(tokens.nextToken()); 


        int start = Integer.parseInt(buffer.readLine()); 

        List<Node>[] graph = new List[n+1]; 
        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int node1= Integer.parseInt(tokens.nextToken());
            int node2= Integer.parseInt(tokens.nextToken()); 
            int dist = Integer.parseInt(tokens.nextToken()); 

            graph[node1].add(new Node(node2, dist));
            graph[node2].add(new Node(node1, dist)); 
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX_DIST); 
        dist[start] = 0; 
        PriorityQueue<Node> que = new PriorityQueue<>(); 
        que.add(new Node(start, 0)); 
        while(!que.isEmpty()){
            Node current = que.poll(); 

            if(dist[current.idx]!=current.dist)continue; 

            for(Node next : graph[current.idx]){
                int newDist = dist[current.idx] + next.dist; 

                if(dist[next.idx]>newDist){
                    dist[next.idx] = newDist; 
                    que.add(new Node(next.idx, newDist));
                }
            }
        }


        StringBuilder result= new StringBuilder(); 

        for(int node=1; node<=n; node++){
            result.append(dist[node]==MAX_DIST?-1:dist[node]).append("\n");
        }

        System.out.println(result); 






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
        return this.dist - dist; 
    }


}