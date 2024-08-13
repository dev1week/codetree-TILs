import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n = Integer.valueOf(buffer.readLine());

        int[] numbers = new int[n];


        tokens = new StringTokenizer(buffer.readLine());

        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken()); 
        }

        int[] d = new int[n];
        d[0] = numbers[0]; 

        for(int i=1; i<n; i++){
            d[i]= Math.max(numbers[i], numbers[i]+d[i-1]);
        }

        System.out.println(Arrays.stream(d).max().getAsInt()); 

        



        //d[i] i번째 수까지 고려했을 때 얻을 수 있는 최대 점수 
            //i번째 수를 마지막으로 포함하는 경우 
            //i번째 수가 처음으로 시작하는 경우 
            //d[i] = Math.max(a[i], d[i-1]+a[i]);
    }
}