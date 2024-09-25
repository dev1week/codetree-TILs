import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    private static final int MAX_SIZE = (int) 1e6; 

    public static void main(String[] args) throws IOException{
           

        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int q = Integer.parseInt(tokens.nextToken()); 

        int[] points = Arrays.stream(buffer.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int maxPoint = Arrays.stream(points).max().getAsInt();
        int[] pointCnts = new int[MAX_SIZE+1];
        int[] pointPrefixSum = new int[MAX_SIZE+1];
        for(int point : points){
            pointCnts[point]++; 
        }
        //System.out.println(Arrays.toString(pointCnts)); 
        //n개 점의 위치를 받아 카운팅함.  - o(n) 

        //카운팅 배열을 토대로 누적합을 구한다. - o(n)

        for(int i=1; i<=maxPoint; i++){
            pointPrefixSum[i] = pointPrefixSum[i-1] + pointCnts[i];
        }

        for(int i=maxPoint+1; i<=MAX_SIZE; i++){
            pointPrefixSum[i] = pointPrefixSum[i-1];
        }

        

        //쿼리를 받으며 바로바로 누적합으로 계산해낸다. o(1 * q) 
        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine());

            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken()); 

            result.append(getPartSum(start, end, pointPrefixSum, pointCnts)).append("\n");

        }

        System.out.println(result);
    }

    private static int getPartSum(int start, int end, int[] prefixSum, int[] pointCnts){
        return prefixSum[end] - prefixSum[start]+pointCnts[start]; 
    }
}