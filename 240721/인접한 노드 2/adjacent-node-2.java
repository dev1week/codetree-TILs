import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    static int[] nodes; 
    static int[][] d;
    static List<Integer>[] graph; 
    static List<Integer> route;
    static final int YES =1;
    static final int NO = 0; 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());
        nodes = new int[n+1];
        d = new int[n+1][2];
        graph = new List[n+1]; 
        route = new ArrayList<>(); 

        tokens = new StringTokenizer(buffer.readLine());
        for(int node=1; node<=n; node++){
            graph[node] = new ArrayList<>();

            nodes[node] = Integer.parseInt(tokens.nextToken()); 
        }

        for(int edge=0; edge<n-1; edge++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken()); 

            graph[node1].add(node2);
            graph[node2].add(node1);
        }


        dfs(1, -1);

        if(d[1][YES]>d[1][NO]){
            
            findRoute(1,YES, -1);
        }else{
            findRoute(1, NO, -1);
        }

        StringBuilder result = new StringBuilder(); 
        result.append(Math.max(d[1][YES], d[1][NO])).append("\n");
        Collection.sort(route);

        for(int node : route){
            result.append(node).append(" ");
        }
        System.out.println(result);
        

        
    }

    private static void findRoute(int current, int status, int parent){
        
        if(status==YES){
            route.add(current);

            for(int child : graph[current]){
                if(child == parent) continue; 
                findRoute(child, NO, current);
            }
        }else{
            for(int child : graph[current]){
                if(child == parent )continue; 
                if(d[child][YES]>d[child][NO]){
                    findRoute(child, YES, current);
                }else{
                    findRoute(child, NO, current);
                }
            }
        }

    }

    private static void dfs(int current, int parent){
        d[current][YES] = nodes[current];

        for(int child : graph[current]){
            if(child == parent) continue; 

            dfs(child, current); 

            d[current][YES] += d[child][NO];
            d[current][NO] += Math.max(d[child][NO], d[child][YES]);
        }

    }
}