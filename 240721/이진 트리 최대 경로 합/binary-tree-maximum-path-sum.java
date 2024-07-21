import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int[] distance; 

    static final int ROOT = 1; 
    
    static List<Integer>[] graph;
    static int[] nodes; 

    public static void main(String[] args) throws IOException{
        int numOfNode = Integer.parseInt(buffer.readLine());

        distance = new int[numOfNode+1];
        graph = new List[numOfNode+1];
        nodes = new int[numOfNode+1];
        for(int node=1; node<=numOfNode; node++){
            graph[node] = new ArrayList<>(); 
        }

        for(int edge=0; edge<numOfNode-1; edge++){
            tokens = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int node=1; node<=numOfNode; node++){
            nodes[node] = Integer.parseInt(buffer.readLine());
        }

        dfs(ROOT, -1);
        int max = Arrays.stream(distance).max().orElseThrow(NoSuchElementException::new);
        System.out.println(max);
    }


    private static void dfs(int current, int parent){
        distance[current] = nodes[current]; 
        int childTotal = 0; 
        int maxDistance = 0; 
        for(int child :graph[current]){
            if(parent == child) continue; 

            dfs(child, current); 

            maxDistance = Math.max(maxDistance, distance[child]);
            childTotal+= distance[child];
        }

        distance[current] += Math.max(maxDistance, childTotal); 
        //자식이 하나일 경우 

        //자식이 두개일 경우 


        //자식이 0개일 경우 

    }
}