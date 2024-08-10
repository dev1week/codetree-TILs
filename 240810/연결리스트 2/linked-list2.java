import java.io.*;
import java.util.*; 

class Node{
    int id; 
    Node prev, next; 

    public Node(int id){
        this.id = id; 
        this.prev = null;
        this.next = null; 
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(this.prev!=null?this.prev.id:0)
            .append(" ")
            .append(this.next!=null?this.next.id:0);
        return sb.toString(); 
    }

    public int getNextNode(){
        return this.next!=null?this.next.id:0;
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static Map<Integer, Node>nodes = new HashMap<>();  
    public static void main(String[] args) throws IOException{
        
        int n= Integer.parseInt(buffer.readLine()); 

        for(int node=1; node<=n; node++){
            Node current = new Node(node);
            nodes.put(node, current);
        }

        
        
        int q = Integer.parseInt(buffer.readLine());    
        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine());

            int opt = Integer.parseInt(tokens.nextToken());
            int i = Integer.parseInt(tokens.nextToken());
            if(opt==1){
                delete(nodes.get(i));
            }else if(opt==2){
                int j = Integer.parseInt(tokens.nextToken());
                insertPrev(nodes.get(i), nodes.get(j));
            }else if(opt==3){
                int j = Integer.parseInt(tokens.nextToken());
                insertNext(nodes.get(i), nodes.get(j));
            }else if(opt==4){
                result.append(nodes.get(i)).append("\n");
            }
        }


        for(int id=1; id<=n; id++){
            result.append(nodes.get(id).getNextNode()).append(" ");
        }

        System.out.println(result); 
    }

    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }

    private static void insertPrev(Node target, Node insert){
        connect(target.prev, insert);
        connect(insert, target);
    }

    private static void insertNext(Node target, Node insert){
        connect(insert, target.next);
        connect(target, insert);
    }

    private static void delete(Node target){
        if(target.next!=null)target.next.prev = target.prev;
        if(target.prev!=null)target.prev.next = target.next; 
        target.next = target.prev = null; 
    }


}