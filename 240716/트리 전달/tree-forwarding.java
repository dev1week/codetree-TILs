import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 


    static int[] d;
    static int[] nodes; 
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());    
        int n = Integer.parseInt(tokens.nextToken()); 
        int m = Integer.parseInt(tokens.nextToken()); 

        d = new int[n+1];
        nodes = new int[n+1];
        graph = new List[n+1];

        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }
        int root = -1; 
        tokens = new StringTokenizer(buffer.readLine()); 
        for(int node1=1; node1<=n; node1++){
            int node2 = Integer.parseInt(tokens.nextToken());
            
            if(node2==-1){
                root = node1; 
            }else{
                graph[node1].add(node2);
                graph[node2].add(node1);
            }
        }

        for(int operation=0; operation<m; operation++){
            tokens = new StringTokenizer(buffer.readLine());
            int targetNode = Integer.parseInt(tokens.nextToken());
            int score = Integer.parseInt(tokens.nextToken());

            nodes[targetNode] += score; 
        }



        dfs(root, -1, 0);

        StringBuilder result = new StringBuilder();

        for(int node=1; node<=n; node++){
            result.append(d[node]).append(" ");
        }

        System.out.println(result); 

    }
    private static void dfs(int current, int parent, int tot){
        d[current] = nodes[current]+tot;

        for(int child : graph[current]){
            if(child==parent) continue; 
            dfs(child, current, tot+nodes[current]); 
        }
        
        

    }
}