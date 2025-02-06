import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[]args)throws IOException{
        //dp[i] i번 노드의 서브트리에 속한 정점의 개수
        //dp[i] = 1
        //dp[i] += dp[c];


        //dfs 순회를 한다.
            //순회가 끝난후
            //초기값을 설정한다.
            //현재 노드의 dp 값을 갱신한다.


        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int r = Integer.parseInt(tokens.nextToken());
        int q = Integer.parseInt(tokens.nextToken());

        List<Integer>[] graph = intitGraph(n);

        addEdges(n, graph);


        int[] numOfSubtreeNodesFrom = new int[n+1];
        boolean[] isVisited = new boolean[n+1];

        isVisited[r]=   true;
        dfs(r,n,graph,isVisited, numOfSubtreeNodesFrom);

        StringBuilder result = new StringBuilder();
        for(int query=0; query<q; query++){
            int queryNode = Integer.parseInt(buffer.readLine());
            result.append(numOfSubtreeNodesFrom[queryNode]).append("\n");
        }

        System.out.println(result);


    }

    private static void dfs(int current, int n, List<Integer>[] graph, boolean[] isVisited, int[] numOfSubtreeNodesFrom) {

        for(int child: graph[current]){
            if(!isVisited[child]){
                isVisited[child] = true;
                dfs(child, n, graph, isVisited, numOfSubtreeNodesFrom);
                isVisited[child] = false;
            }
        }

        numOfSubtreeNodesFrom[current] = 1;
        for(int child: graph[current]){
            if(!isVisited[child]){
                numOfSubtreeNodesFrom[current] += numOfSubtreeNodesFrom[child];
            }
        }
    }

    private static void addEdges(int n, List<Integer>[] graph) throws IOException {
        for(int edge = 0; edge< n-1; edge++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.parseInt(tokens.nextToken());
            int node2 = Integer.parseInt(tokens.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }

    private static List<Integer>[] intitGraph(int n) {
        List<Integer>[] graph = new List[n +1];
        for(int node = 0; node<= n; node++){
            graph[node] = new ArrayList<>();
        }
        return graph;
    }

}