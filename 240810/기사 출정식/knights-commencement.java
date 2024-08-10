import java.io.*;
import java.util.*; 

class Knight{
    int id;

    Knight prev, next; 

    public Knight(int id){
        this.id = id; 
    }

    @Override
    public String toString(){
        if(this.prev==null||this.next==null) return "test"; 
        return this.next.id+" "+this.prev.id; 
    }

}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        Map<Integer, Knight> knights = new HashMap<>(); 

        

        int[] ids = Arrays.stream(buffer.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray(); 
        for(int id : ids){
            knights.put(id, new Knight(id)); 
        }

        for(int i=0; i<n-1; i++){
            connect(knights.get(ids[i]), knights.get(ids[i+1])); 
        }
        connect(knights.get(ids[n-1]), knights.get(ids[0])); 

        // System.out.println(current.id);

        // System.out.println(Arrays.toString(knights));


        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<m; query++){

            int call = Integer.parseInt(buffer.readLine());
            result.append(knights.get(call)).append("\n"); 
            delete(knights.get(call));
        }

        System.out.println(result); 
        
    }

    private static void connect(Knight s, Knight e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }

    private static void delete(Knight n){
        connect(n.prev, n.next); 
        n.next=n.prev=null;
    }
}