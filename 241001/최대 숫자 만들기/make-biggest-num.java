import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine()); 


        Integer[] numbers = new Integer[n];

        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(buffer.readLine()); 
        }

        Arrays.sort(numbers, 0, n, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String s1 = Integer.toString(a)+Integer.toString(b);
                String s2 = Integer.toString(b)+Integer.toString(a);

                return s2.compareTo(s1);
            }
        });

        StringBuilder result = new StringBuilder(); 
        for(Integer number : numbers){
            result.append(number);
        }

        System.out.println(result);



    }
}