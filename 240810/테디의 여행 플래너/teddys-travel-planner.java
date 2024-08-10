import java.io.*; 
import java.util.*; 
class Node{
    String city;
    Node prev, next;
    public Node(String city){
        this.city = city;
        this.prev = null;
        this.next = null; 
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        String prevCity = this.prev!=null? this.prev.city:"-1";
        String nextCity = this.next!=null? this.next.city:"-1";

        if(prevCity.equals(nextCity)||prevCity.equals("-1")||nextCity.equals("-1")){
            return "-1";
        }

        return result.append(prevCity).append(" ").append(nextCity).toString();
    }
}
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int q = Integer.parseInt(tokens.nextToken()); 
        
        Node[] firstCities = new Node[n];
        
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<n; i++){
            firstCities[i] = new Node(tokens.nextToken());
        }

        Node pinset = new Node("0"); 
        for(int i=0; i<n-1; i++){
            Node s = firstCities[i];
            Node e = firstCities[i+1];
            connect(s,e); 
            if(i==0) pinset = s;
            if(i==n-2)connect(e, pinset); 
        }

        
        StringBuilder result = new StringBuilder(); 

       
        
        for(int query=0; query<q; query++){
            tokens= new StringTokenizer(buffer.readLine());
            int opt=Integer.parseInt(tokens.nextToken()); 
            //result.append(opt).append("\n"); 
            if(opt==1){
                if(pinset.next!=null){
                    pinset = pinset.next; 
                }
            }else if(opt==2){
                if(pinset.prev!=null){
                    pinset = pinset.prev; 
                }
            }else if(opt==3){
                if(pinset.next!=null){
                    remove(pinset.next); 
                }
                
            }else if(opt==4){
                String city= tokens.nextToken();
                insertNext(pinset, new Node(city));
            }
            result.append(pinset).append("\n");
        }   
        System.out.println(result); 


        
    }

    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 

    }

    private static void print(Node start){
        while(start.next!=null){
            System.out.print(start.city+" "); 
            start = start.next; 
        }
        System.out.println(start.city);
    }
    private static void insertNext(Node target, Node insert){
        connect(insert, target.next);
        connect(target, insert); 
    }

    private static void remove(Node n){
        if(n.next!=null)n.next.prev = n.prev;
        if(n.prev!=null)n.prev.next = n.next; 
        n.prev = n.next = null; 
    }
}