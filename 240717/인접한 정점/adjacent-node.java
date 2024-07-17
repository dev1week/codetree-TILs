import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static int n; 
    static int[][] d;
    static int[] nodes;
    static List<Integer>[] graph; 

    static final int YES = 1;
    static final int NO = 0; 

    // d[i][NO] +=  d[자식][YES]
    // d[i][YES] = 1 
    // d[i][YES] += d[자식][NO]

    public static void main(String[] args) throws IOException{
        n = Integer.valueOf(buffer.readLine());

        graph = new List[n+1]; 
        nodes = new int[n+1];
        d = new int[n+1][2]; 
        for(int node=1; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        tokens = new StringTokenizer(buffer.readLine());


        for(int node1=1; node1<=n; node1++){
            nodes[node1] = Integer.parseInt(tokens.nextToken()); 
        }

        for(int edge=0; edge<n-1; edge++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken()); 

            graph[node1].add(node2);
            graph[node2].add(node1); 
        }

        dfs(1, -1);

        System.out.println(Math.max(d[1][YES], d[1][NO]));

    }

    private static void dfs(int current, int parent){
        d[current][YES] = nodes[current];
        d[current][NO] = 0; 

        for(int child : graph[current]){
            if(child == parent) continue; 

            dfs(child, current);

            d[current][YES] += d[child][NO];
            d[current][NO] += d[child][YES]; 
        }
    }
}