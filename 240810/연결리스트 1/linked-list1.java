import java.io.*;
import java.util.*; 

class Node{
    String data;
    Node prev, next;


    public Node(String data){
        this.prev = null;
        this.next = null; 
        this.data = data; 
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append(this.prev==null?"(Null)": this.prev.data)
            .append(" ")
            .append(this.data)
            .append(" ")
            .append(this.next==null?"(Null)":this.next.data);

        return result.toString();
    }
}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{

        Node current = new Node(buffer.readLine()); 

        int n = Integer.parseInt(buffer.readLine());

        StringBuilder result = new StringBuilder(); 
        for(int q=0; q<n; q++){
            tokens = new StringTokenizer(buffer.readLine());

            int opt = Integer.parseInt(tokens.nextToken()); 

            if(opt==1){
                Node insertNode = new Node(tokens.nextToken());
                insertPrev(current, insertNode);
            }else if(opt==2){
                Node insertNode = new Node(tokens.nextToken());
                insertNext(current, insertNode); 
            }else if(opt==3){
                if(current.prev!=null) current = current.prev; 
            }else if(opt==4){
                if(current.next!=null) current= current.next; 
            }
            result.append(current).append("\n");
        }
        System.out.println(result); 
    }

    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }

    private static void insertPrev(Node target, Node insertNode){
        connect(target.prev, insertNode);
        connect(insertNode, target); 
    }

    private static void insertNext(Node target, Node insertNode){
        connect(insertNode, target.next);
        connect(target, insertNode);
    }

}