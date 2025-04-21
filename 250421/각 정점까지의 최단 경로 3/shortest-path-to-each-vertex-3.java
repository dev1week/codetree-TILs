import java.util.*;
import java.io.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    static final int START = 1; 
    static final int CANT_GO = (int)10e5+1; 
    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        int[][] graph = new int[n+1][n+1];

        for(int edge=0; edge<m; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken());
            int dist = Integer.parseInt(tokens.nextToken()); 

            graph[node1][node2] = dist;
            //graph[node2][node1] = dist; 
        }


        int[] dist = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        Arrays.fill(dist, CANT_GO); 

        dist[START] = 0;


        for(int i=1; i<=n; i++){
            int minIdx= -1;

            for(int j=1; j<=n; j++){
                if(isVisited[j])continue; 

                if(minIdx == -1|| dist[minIdx]>dist[j]){
                    minIdx = j; 
                }
            }
            isVisited[minIdx]= true; 
            for(int next=1; next<=n; next++){
                if(graph[minIdx][next]==0)continue; 
                dist[next] = Math.min(dist[next], dist[minIdx]+graph[minIdx][next]);
            }
        }

        StringBuilder result = new StringBuilder();

        for(int node=2; node<=n; node++){
            result.append(dist[node]==CANT_GO?-1:dist[node]).append("\n");
        }


        System.out.println(result); 
    }

}
