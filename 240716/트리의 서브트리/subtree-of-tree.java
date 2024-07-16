import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static List<Integer>[] graph;
    static int[] d; 

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int r = Integer.parseInt(tokens.nextToken());
        int q = Integer.parseInt(tokens.nextToken());
        

        graph = new List[n+1];
        d = new int[n+1]; 

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

        dfs(r, -1);

        StringBuilder result = new StringBuilder();
        for(int query=0; query<q; query++){
            result.append(d[Integer.parseInt(buffer.readLine())]).append("\n");
        }

        System.out.println(result);

    }

    private static void dfs(int current, int parent){
        d[current] = 1;


        for(int child : graph[current]){
            if(child == parent) continue; 
            dfs(child, current);

            d[current] += d[child]; 

        }

    }
}