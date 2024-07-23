import java.io.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    //d[i] n=i일 때 가능한 경우의 수 

    //d[i] = 2*d[i-1] + 2*d[i-2];  

    public static void main(String[] args) throws IOException{
        int n = Integer.valueOf(buffer.readLine());
        long[] d = new long[1001];

        d[1] = 2;
        d[2] = 7;
        d[3] = 22; 


        for(int i=4; i<=1000; i++){
            d[i] = d[i-1]*2 + d[i-2]*3 + d[i-3]*2;
            d[i] %= 1000000007;
        }
        System.out.println(d[n]);

    }
}