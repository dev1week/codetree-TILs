import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static int[] distanceFromLeaf; 
    static List<Integer>[] graph; 




    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int numOfNodes = Integer.parseInt(tokens.nextToken());
        int root = Integer.parseInt(tokens.nextToken());
        int limit = Integer.parseInt(tokens.nextToken()); 

        distanceFromLeaf = new int[numOfNodes+1];
        graph = new List[numOfNodes+1];

        for(int node=1; node<=numOfNodes; node++){
            graph[node] = new ArrayList<>(); 
        } 


        for(int edge=0; edge<numOfNodes-1; edge++){
            tokens = new StringTokenizer(buffer.readLine());

            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }


        //각 노드로부터 리프 노드까지의 거리를 구하기 
        dfs(root, -1);

        int result = 0; 
        
        for(int node=1; node<=numOfNodes; node++){
            if(node==root) continue; 

            if(distanceFromLeaf[node]>=limit) result+=2;

        }

        

        System.out.println(result);
    }


    static void dfs(int current, int parent){
        int minDistance = Integer.MAX_VALUE; 
        for(int child : graph[current]){
            if(child==parent) continue; 

            dfs(child, current); 
            minDistance = Math.min(distanceFromLeaf[child], minDistance);
        }

        if(minDistance!=Integer.MAX_VALUE) {
            distanceFromLeaf[current] = minDistance+1;
        }

    }
}