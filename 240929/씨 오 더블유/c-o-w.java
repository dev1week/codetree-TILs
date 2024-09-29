import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static final char C = 'C';
    static final char O = 'O';
    static final char W = 'W';

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine()); 
        String data = buffer.readLine(); 

        List<Integer> oIdx = new ArrayList<>(); 
        int[] cL = new int[n];
        int[] wR = new int[n];

        if(data.charAt(0)==C){
            cL[0] = 1; 
        }

        if(data.charAt(n-1)==W){
            wR[n-1] = 1;
        }


        for(int i=0; i<n; i++){
            if(data.charAt(i)==O){
                oIdx.add(i); 
            }
        }

        for(int i=1; i<n; i++){
            cL[i] = cL[i-1];
            if(data.charAt(i)==C){
                cL[i] ++;
            }
        }

        for(int i=n-2; i>=0; i--){
            wR[i] = wR[i+1];
            if(data.charAt(i)==W){
                wR[i]++;
            }
        }
        
        int result = 0; 

        for(int i : oIdx){
            int tmp = cL[i]*wR[i];
            result += tmp; 
        }
        System.out.println(result);

    }
}