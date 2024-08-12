import java.io.*; 
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken()); 

        int[] numbers = new int[n]; 
        int maxNum = 0; 
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(buffer.readLine()); 
            maxNum = Math.max(maxNum, numbers[i]);
        }

        int h = maxNum; 
        int l = 0;

        while(h>l){
            int mid = (h+l+1)/2;
            if(isValid(mid, numbers, m )){
                l = mid;
            }else{
                h = mid-1; 
            }
        }
        System.out.println(h); 
    }

    private static boolean isValid(int mid, int[] numbers, int limit){
        int count = 0; 
        for(int number: numbers){
            count += number/mid;
        }

        return count>=limit;

    }
}