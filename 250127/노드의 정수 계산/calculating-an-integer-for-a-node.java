import java.io.*;
import java.util.*; 

public class Main {
    static StringTokenizer tokens; 
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    
    static final int ROOT = 1; 

    //적혀 있는 수가 양수일 경우 부모 노드에 자신의 값을 더합니다. 

    //적혀 있는 수가 음수일 경우 아무 것도 하지 않습니다. 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 

        int[] nodeDatas = new int[n+1]; 
        List<Integer>[] graph = getGraph(n, nodeDatas);


        //dfs 탐색을 진행하여 treeDp를 구합니다. 
        int[] treeDp = getTreePartSum(nodeDatas, graph, n); 

        System.out.println(treeDp[ROOT]);

    }

    private static int[] getTreePartSum(int[] nodeDatas, List<Integer>[] graph, int n){

        boolean[] isVisited = new boolean[n+1];
        int[] treeDp = new int[n+1]; 
        dfs(ROOT, graph, treeDp, nodeDatas, isVisited);

        return treeDp;
    }


    private static void dfs(int current, List<Integer>[] graph, int[] treeDp, int[] nodeDatas, boolean[] isVisited){
        int partSum = 0; 
        
        for(int child: graph[current]){
            dfs(child, graph, treeDp, nodeDatas, isVisited);     
        }

        treeDp[current] = nodeDatas[current]; 
        for(int child: graph[current]){
            if(treeDp[child]>0){
                treeDp[current] += treeDp[child];
            }
        }

        return; 

    }

    private static List<Integer>[] getGraph(int n, int[] nodeDatas)throws IOException{
        List<Integer>[] graph = initGraph(n);
        
        for(int node=2; node<=n; node++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int opt = Integer.parseInt(tokens.nextToken()); 
            int data = Integer.parseInt(tokens.nextToken()); 
            int parent = Integer.parseInt(tokens.nextToken()); 
            
            nodeDatas[node] = opt==1?data:data*(-1);
            graph[parent].add(node);
            
        }
        return graph;
    }

    private static List<Integer>[] initGraph(int n){
        List<Integer>[] graph = new List[n+1]; 
        for(int node=0; node<=n; node++){
            graph[node] = new ArrayList<>(); 
        }
        return graph; 
    }
}