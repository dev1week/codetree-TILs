import java.util.*;
import java.io.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static final int ROOT = 1; 
    static int[] nodes;
    static List<Integer>[] graph; 
    static int[] d; 



    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(buffer.readLine()); 

        nodes = new int[n+1];
        graph = new List[n+1]; 
        d = new int[n+1]; 

        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int node=2; node<=n; node++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int sign = Integer.parseInt(tokens.nextToken());

            int data = Integer.parseInt(tokens.nextToken()); 

            data = sign==0? (-1)*data : data; 

            int parent = Integer.parseInt(tokens.nextToken()); 

            graph[parent].add(node);
            graph[node].add(parent);
            
            nodes[node] = data; 
        }

        dfs(ROOT, -1);
        System.out.println(d[ROOT]);

    }

    private static void dfs(int current, int parent){
        d[current] = nodes[current];


        for(int child : graph[current]){
            if(child==parent) continue; 
            dfs(child, current);
            if(d[child]>0){
                d[current] += d[child];
            }
            

        }


    }
}