import java.io.*;
import java.util.*; 

class Node{
    String data;
    Node prev, next;

    private static final String NULL = "(Null)";
    public Node(String data){
        this.data = data;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        return result.append(this.prev==null?NULL:this.prev.data).append(" ").append(this.data).append(" ").append(this.next==null?NULL:this.next.data).toString();
    }
}




public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }

    private static void insertNext(Node target, Node insert){
        connect(insert, target.next);
        connect(target, insert);
    }

    private static void insertPrev(Node target, Node insert){
        connect(target.prev, insert);
        connect(insert, target); 
    }

    public static void main(String[] args) throws IOException{
        Node current = new Node(buffer.readLine());

        int n = Integer.parseInt(buffer.readLine()); 
        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<n; query++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int opt = Integer.parseInt(tokens.nextToken());
            
            if(opt==1){
                String data = tokens.nextToken(); 
                //cur의 앞에 생성하기 
                insertPrev(current, new Node(data)); 
            }else if(opt==2){
                String data = tokens.nextToken(); 
                //cur의 뒤에 삽입하기 
                insertNext(current, new Node(data));
            }else if(opt==3){
                //cur을 이전 노드로 변경하기 
                if(current.prev!=null) current= current.prev; 
            }else if(opt==4){
                //cur을 다음 노드로 변경하기 
                if(current.next!=null) current= current.next; 

            }
            result.append(current).append("\n");
        }       
        System.out.println(result); 
    }


}