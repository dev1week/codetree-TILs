import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        int n = Integer.parseInt(buffer.readLine());
        boolean[] numbers = new boolean[n]; 
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<n; i++){
            int data = Integer.parseInt(tokens.nextToken());
            if(data==0){
                numbers[i] = false; 
            }else{
                numbers[i] = true;
            }
        }

        int cnt = 0; 
        for(int i=1;i<n; i++){
            if(!numbers[i-1]){
                numbers[i] = !numbers[i];          
                numbers[i-1] = !numbers[i-1];
                if(i!=n-1){
                    numbers[i+1] = !numbers[i+1];
                }
                          
                cnt++;
            }

        }

        //System.out.println(Arrays.toString(numbers));

        if(isValid(numbers)){
            System.out.println(cnt); 
        }else{
            System.out.println(-1);
        }
        //하나씩 순회한다. 
            //전의 칸이 0이면 
                //전의칸, 현재칸, 뒤의칸을 전부 상태변경하낟. 
                //카운트를 센다. 

        
    }

    private static boolean isValid(boolean[] numbers){
        for(boolean number: numbers){
            if(!number){
                return false; 
            }
        }

        return true; 
    }
}