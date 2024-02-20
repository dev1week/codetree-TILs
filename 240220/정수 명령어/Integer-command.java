import java.util.*;
import java.io.*; 

public class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static TreeSet<Integer> tree; 


    public static void main(String[] args) throws IOException{

        StringBuilder result = new StringBuilder(); 

        int t = Integer.valueOf(buffer.readLine());

        for(int test=0; test<t; test++){
            int k = Integer.valueOf(buffer.readLine()); 
            tree = new TreeSet<>(); 
            for(int simulation=0; simulation<k; simulation++){

                
                tokens = new StringTokenizer(buffer.readLine()); 

                String operator = tokens.nextToken(); 

                int data = Integer.valueOf(tokens.nextToken()); 

                simulation(operator, data); 



            }
             if(!tree.isEmpty()){
                result.append(tree.last()).append(" ");
                result.append(tree.first()).append("\n");
            }else{
                result.append("EMPTY\n");
            }
                
            

           

        }
        System.out.println(result); 
        

        
        //i 정수를 큐에 넣습니다. 


        //비어 있을 경우 무시합니다. 
            //d 1 큐에서 최대값을 삭제합니다. 

            // d-1  큐에서 최솟값을 삭제합니다.
    }

    static void simulation(String op, int data){
        

        if(op.equals("D")){
            if(tree.isEmpty()){
                return; 
            }else{
                if(data==1){
                    tree.remove(tree.last());
                }else{
                    tree.remove(tree.first());
                }
            }
        }else{
            tree.add(data);
        }

    }
}