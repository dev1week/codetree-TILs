import java.io.*;
import java.util.*; 


class Node{
    int id;

    Node prev, next;

    public Node(int id){
        this.id = id; 
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        return result.append(this.prev==null?0:this.prev.id).append(" ").append(this.next==null?0:this.next.id).toString(); 
    }

    public int getNextId(){
        return this.next==null?0:this.next.id; 
    }
}


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 



    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine()); 
        int q = Integer.parseInt(buffer.readLine()); 

        Node[] nodes = new Node[n+1];

        for(int node=1; node<=n; node++){
            nodes[node] = new Node(node); 
        } 


        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine());

            int opt = Integer.parseInt(tokens.nextToken());
            int i = Integer.parseInt(tokens.nextToken());

            if(opt==1){
                //  i번 노드를 연결리스트에서 제거함 

                delete(nodes[i]);

            }else if(opt==2){
                int j = Integer.parseInt(tokens.nextToken()); 
                //j번 노드를 I번 노드 앞에 삽입하기 
                insertPrev(nodes[i],nodes[j]);

            }else if(opt==3){
                int j = Integer.parseInt(tokens.nextToken()); 
                //j번 노드를 I번 노드 뒤에 삽입하기 
                insertNext(nodes[i], nodes[j]); 

            }else if(opt==4){ 
                //i번 노드의 이전 노드와 다음 노드의 번호 출력하기 
                result.append(nodes[i]).append("\n");
            }


        }

        for(int node=1; node<=n; node++){
            result.append(nodes[node].getNextId()).append(" ");
        }


        System.out.println(result); 

    }

    private static void connect(Node s, Node e){
        if(s!=null) s.next = e;
        if(e!=null) e.prev = s; 
    }

    private static void insertNext(Node target, Node insert){
        connect(insert, target.next);
        connect(target, insert);
    }

    private static void insertPrev(Node target, Node insert){
        connect(target.prev, insert); 
        connect(insert, target);
    }

    private static void delete(Node node){
        if(node.next!=null)node.next.prev = node.prev; 
        if(node.prev!=null)node.prev.next = node.next; 

        node.prev = node.next = null; 
    }

}