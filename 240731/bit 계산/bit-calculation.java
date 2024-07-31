import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    private static int add(int set, int data){
        if(print(set,data)==1) return set;



        return set^(1<<data);
    }

    private static int delete(int set, int data){
        if(print(set,data)==1) return set;
        return set^(1<<data);
    }

    private static int print(int set, int data){
        return (set>>data)&1; 
    }

    private static int toggle(int set, int data){
        return set^(1<<data); 
    }

    private static int clear(){
        return 0; 
    }

    public static void main(String[] args)throws IOException {
        int commandNum = Integer.parseInt(buffer.readLine());
        StringBuilder result = new StringBuilder(); 
        int set = 0; 
        for(int commandIdx = 0 ; commandIdx<commandNum; commandIdx++){
            tokens = new StringTokenizer(buffer.readLine());
            String command = tokens.nextToken();
            int data = Integer.parseInt(tokens.nextToken());

            if(command.equals("add")){
                set = add(set, data);
            }else if(command.equals("delete")){
                set = delete(set, data);
            }else if(command.equals("print")){
                result.append(print(set, data)).append("\n");
            }else if(command.equals("toggle")){
                set = toggle(set, data);
            }else if(command.equals("clear")){
                set = clear(); 
            }
        }
        System.out.println(result); 
    }
}