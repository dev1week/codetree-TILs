import java.util.*; 
import java.io.*; 
public class Main {
    
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args)throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.valueOf(tokens.nextToken());
        long m = Long.valueOf(tokens.nextToken());

        long[] numbers = new long[n];
        TreeSet<Long> datas = new TreeSet<>();

        for(int i=0; i<n; i++){
            numbers[i] = Long.valueOf(buffer.readLine());
            datas.add(numbers[i]); 
        }


        long result = Long.MAX_VALUE; 
        for(long number : numbers){
            if(datas.higher(number+m)!=null){
                if(result>datas.higher(number+m)-number){
                    result = datas.higher(number+m)-number; 
                }
            }
        }

        System.out.println(result); 

    }
   
}