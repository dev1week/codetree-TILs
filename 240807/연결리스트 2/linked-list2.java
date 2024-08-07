import java.io.*;
import java.util.*; 

class Node{
    int id;
    Node prev, next;

    private static final int NULL = 0; 

    public Node(int id){
        this.id = id;
        this.prev = null;
        this.next = null; 
    }

    
    public int nextNode(){
        return this.next != null ? this.next.id : NULL; 
    }

    public int prevNode(){
        return this.prev != null? this.prev.id :NULL; 
    }

    public int currentNode(){
        return id; 
    }

}

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    static final int MAX_NODE_NUM = (int) 1e5; 
    static Node[] nodes = new Node[MAX_NODE_NUM+1]; 

    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(buffer.readLine());
        int q = Integer.parseInt(buffer.readLine());


        for(int i=1; i<=n; i++){
            nodes[i] = new Node(i);
        }

        StringBuilder result = new StringBuilder(); 

        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int opt = Integer.parseInt(tokens.nextToken());
            int i = Integer.parseInt(tokens.nextToken());


            if(opt==1){
                delete(nodes[i]);
            }else if(opt==2){
                int j = Integer.parseInt(tokens.nextToken());
                nodes[j] = new Node(j);
                insertPrev(nodes[i], nodes[j]);
            }else if(opt ==3){
                int j = Integer.parseInt(tokens.nextToken());
                nodes[j] = new Node(j);
                insertNext(nodes[i], nodes[j]);
            }else if(opt==4){
                result.append(print(nodes[i])).append("\n");
            }
        }
        
        for(int i=1; i<=n; i++){
            result.append(nodes[i].nextNode()).append(" "); 
        }

        System.out.println(result);
    }

    private static String print(Node node){
        return node.prevNode()+" "+node.nextNode(); 
    }

    private static void delete(Node targetNode){
        if(targetNode.next!=null)
            targetNode.next.prev = targetNode.prev;
        if(targetNode.prev!=null)
            targetNode.prev.next = targetNode.next; 
        
        targetNode.next = null;
        targetNode.prev = null; 
    }

    private static void insertPrev(Node targetNode, Node insertNode){
        insertNode.prev = targetNode.prev;
        insertNode.next = targetNode; 

        if(insertNode.prev!=null) insertNode.prev.next = insertNode;
        if(insertNode.next!=null) insertNode.next.prev = insertNode; 
    }


    private static void insertNext(Node targetNode, Node insertNode){
        insertNode.prev = targetNode;
        insertNode.next = targetNode.next; 

        if(insertNode.prev!=null) insertNode.prev.next = insertNode;
        if(insertNode.next!=null) insertNode.next.prev = insertNode; 

    }
}