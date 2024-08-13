import java.io.*;
import java.util.*; 


class Node{
    int id;
    Node prev, next;

    public Node(int id){
        this.id = id; 
    }

    public String toString(){
        return String.valueOf(this.id);
    }
}


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(buffer.readLine());

        Node[] nodes = new Node[n+1];

        for(int id=1; id<=n; id++){
            nodes[id] = new Node(id); 
        }
        for(int id=1; id<n; id++){
            connect(nodes[id], nodes[id+1]);
        }

        int q = Integer.parseInt(buffer.readLine()); 

        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());
            int d = Integer.parseInt(tokens.nextToken());


            swap(nodes[a], nodes[b], nodes[c], nodes[d]);
        }

        StringBuilder result = new StringBuilder(); 

        Node start = nodes[1];

        while(start.prev!=null){
            start.prev = start;
        }

        while(start.next!=null){
            result.append(start).append(" ");
            start = start.next; 
        }result.append(start);

        System.out.println(result); 
    }


    private static void swap(Node a, Node b, Node c, Node d){
        Node afterPrevA = c.prev; 
        Node afterNextB = d.next; 

        Node afterPrevC = a.prev; 
        Node afterNextD = b.next; 

        if(b.next==c){
            afterPrevA = d;
            afterNextD = a; 
        }
        if(d.next==a){
            afterNextB = c; 
            afterPrevC = b; 
        }

        connect(afterPrevA, a);
        connect(b, afterNextB); 

        connect(afterPrevC, c); 
        connect(d,afterNextD);
    }

    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }
}