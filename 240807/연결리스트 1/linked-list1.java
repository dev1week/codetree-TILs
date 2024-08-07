import java.io.*;
import java.util.*; 

class Node{
    String data;
    Node next, prev;

    public Node(String data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    private static final String NULL = "(Null)";


    private static void insertPrev(Node targetNode, Node insertNode){
        insertNode.prev = targetNode.prev;
        insertNode.next = targetNode; 

        if(insertNode.next!=null)insertNode.next.prev = insertNode;
        if(insertNode.prev!=null)insertNode.prev.next = insertNode; 
    }

    //targetNode 뒤에 삽입하기 
    private static void insertNext(Node targetNode, Node insertNode){
        insertNode.next = targetNode.next;
        insertNode.prev = targetNode; 

        if(insertNode.next!=null)insertNode.next.prev = insertNode; 
        if(insertNode.prev!=null)insertNode.prev.next = insertNode; 
    }

    public static void main(String[] args) throws IOException{
        Node current = new Node(buffer.readLine()); 

        int n = Integer.parseInt(buffer.readLine()); 
        StringBuilder result = new StringBuilder(); 
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(buffer.readLine()); 
            int operation = Integer.parseInt(tokens.nextToken()); 

            if(operation ==1){
                String data = tokens.nextToken();
                Node insertNode = new Node(data);
                //current 앞에 삽입하기 
                insertPrev(current, insertNode);
                
            }else if(operation==2){
                String data = tokens.nextToken();
                Node insertNode = new Node(data);
                insertNext(current, new Node(data)); 
            }else if(operation==3){
                current = moveBackward(current);
            }else if(operation==4){
                current = moveForward(current); 
            }
            result.append(print(current)).append("\n");
        }
        System.out.println(result); 
    }

    private static Node moveForward(Node node){
        return node.next!=null? node.next : node; 
    }

    private static Node moveBackward(Node node){
        return node.prev!=null?node.prev:node; 
    }

    private static String print(Node node){
        StringBuilder info = new StringBuilder(); 
        if(node.prev!=null){
            info.append(node.prev.data).append(" ");
        }else{
            info.append(NULL).append(" ");
        }

        info.append(node.data).append(" ");

        if(node.next!=null){
            info.append(node.next.data).append(" ");
        }else{
            info.append(NULL).append(" ");
        }

        return info.toString(); 
    }
}