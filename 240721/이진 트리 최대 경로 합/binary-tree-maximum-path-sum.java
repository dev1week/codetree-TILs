import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int[] distance; 
    static int[] distance2;

    static final int ROOT = 1; 
    
    static List<Integer>[] graph;
    static int[] nodes; 

    public static void main(String[] args) throws IOException{
        int numOfNode = Integer.parseInt(buffer.readLine());

        distance = new int[numOfNode+1];
        distance2 = new int[numOfNode+1];
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

        dfs2(ROOT,-1);
        
        int max = Arrays.stream(distance2).max().orElseThrow(NoSuchElementException::new);
        

        System.out.println(max);
    }

    //distance[i] = i번 노드를 끝으로하는 경로 중 최대 경로합 
    private static void dfs(int current, int parent){
        distance[current] = nodes[current]; 
        int childTotal = 0; 
        int maxDistance = 0; 
        for(int child :graph[current]){
            if(parent == child) continue; 

            dfs(child, current); 

            maxDistance = Math.max(maxDistance, distance[child]);
            
        }

        distance[current] += Math.max(maxDistance, childTotal); 
        //자식이 하나일 경우 

        //자식이 두개일 경우 


        //자식이 0개일 경우 

    }

    //distance2[i] i를 경로로 하는 경우에서 최대 값 
    //distance2[i] = nodes[i] + Math.max(distance[left], 0 ) + Math.max(distance[right], 0 );
    private static void dfs2(int current, int parent){
        distance2[current] = nodes[current]; 

        for(int child: graph[current]){
            if(child==parent) continue; 
            dfs(child, current);
            distance2[current] += Math.max(distance[child], 0);
        }


    }   


}