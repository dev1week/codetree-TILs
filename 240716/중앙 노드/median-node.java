import java.io.*;
import java.util.*; 

public class Main {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens; 
    //처음으로 자식 노드가 2개 이상이 되는 노드를 중앙 노드라고 정의한다. 

    //그런 노드가 없을 경우 그래프의 리프 노드를 중앙노드로 정의한다. 

    private static int centerNode =-1; 

    private static int[] sizes; 
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int root = Integer.parseInt(tokens.nextToken()); 

        sizes = new int[n+1];
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

        dfs(root, -1);

        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;

        for(int centerChild :graph[centerNode]){
            maxSize = Math.max(maxSize, sizes[centerChild]);
            minSize = Math.min(minSize, sizes[centerChild]);
        }
        System.out.println(maxSize-minSize); 

        //중앙 노드의 자식 중 가장 크기가 큰 서브트리의 크기와 가장 크기가 작은 서브 트리의 크기 차이를 구하기   
    }

    private static void dfs(int current, int parent){
        sizes[current] = 1; 

        if(graph[current].size()>=3&&centerNode==-1){
            centerNode = current; 
        }

        if(graph[current].size()==1&&centerNode==-1){
            centerNode = current;
        }

        for(int child: graph[current]){
            if(parent==child) continue; 
            dfs(child, current);
            sizes[current] += sizes[child];
        }
    }




}