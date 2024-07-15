import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    //n개의 정점 
    static int[][] d; 
    static List<Integer>[] graph; 
    static final int ON=1;
    static final int OFF=0;
    //간선의 양 끝 두 정점중 적어도 하나의 정점 위에는 물건이 놓여있어야함. 




    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(buffer.readLine());
        d = new int[n+1][2];
        graph = new List[n+1];

        for(int node=1; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int edge=0; edge<n-1; edge++){
            tokens = new StringTokenizer(buffer.readLine()); 
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken()); 

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        dfs(1,-1);
        

        System.out.println(Math.min(d[1][ON], d[1][OFF]));
    }

    static void dfs(int current, int parent){
        d[current][ON] = 1;

        for(int child : graph[current]){
            if(child==parent)continue;
            
            dfs(child, current);
            d[current][ON] += Math.min(d[child][ON], d[child][OFF]); 
            d[current][OFF] += d[child][ON];

        }

    }
}