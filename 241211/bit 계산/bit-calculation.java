import java.io.*;
import java.util.*;




public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder result = new StringBuilder();

    public static boolean isExist(int x, int set){
        int result = (set>>x)&1;
        return result==1;
    }

    public static int add(int x, int set){
        if(isExist(x, set))return set;
        return set += (1<<x);
    }

    public static int delete(int x, int set){
        if(!isExist(x, set))return set;
        return set -= (1<<x);
    }

    public static int clear(){
        return 0; 
    }

    public static void print(int x, int set){
        result.append(isExist(x,set)?1:0).append("\n");
    }

    public static int toggle(int x, int set){
        set ^= (1<<x);
        return set;
    }



    public static void main(String[] args) throws IOException{
        int q = Integer.parseInt(buffer.readLine());

        int set = 0; 

        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine());

            String command = tokens.nextToken();
            

            if(command.equals("clear")){
                set = clear();
            }else{
                int x = Integer.parseInt(tokens.nextToken());
                if(command.equals("add")){
                    set = add(x, set);
                }else if(command.equals("delete")){
                    set = delete(x, set);
                }else if(command.equals("print")){
                    print(x,set);
                }else if(command.equals("toggle")){
                    set = toggle(x,set);
                }
            } 
        }
        System.out.println(result);
    }
}