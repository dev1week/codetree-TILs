import java.util.*; 
import java.io.*; 
public class Main {
    
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args)throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        int n = Integer.valueOf(tokens.nextToken());
        long m = Long.valueOf(tokens.nextToken());

        TreeSet<Long> offsets = new TreeSet<>(); 
        long[] numbers = new long[n];
        //n개의 정수를 배열에 입력 받는다. 
        for(int i=0; i<n; i++){
            numbers[i] = Long.valueOf(buffer.readLine());
        }
        

        
        //n개의 정수를 정렬한다.
        Arrays.sort(numbers);
        //모든 차이를 구한다. => 트리에 때려 박는다. 

        for(int i=n-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                if(i!=j){
                    long offset = numbers[i] - numbers[j]; 
                    offsets.add(offset); 
                }
            }
        }
        

        if(offsets.ceiling(m)!=null){
            System.out.println(offsets.ceiling(m));
        }else{
            System.out.println(-1); 
        }

        //트리.ceiling(m)이 있는지 확인 
            //있으면 바로 출력 
            //없으면 -1 출력 

    }
   
}