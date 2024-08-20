import java.io.*;
import java.util.*; 
class Node{
    int id;
    Node next, prev;

    public Node(int id){
        this.id = id; 
    }

    public String toString(){
        return this.id+"";
    }

    public String print(){
        if(this.prev==null||this.next==null){
            return "-1";
        }else{
            return this.prev.id+" "+this.next.id;
        }
    }
}


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer tokens; 

    
    

    public static void main(String[] args) throws IOException{
        int currentStudent = 2;


        Map<Integer, Node> students = new HashMap<>(); 

        students.put(1, new Node(1)); 

        int q = Integer.parseInt(buffer.readLine()); 

        StringBuilder result = new StringBuilder(); 
        for(int query=0; query<q; query++){
            tokens = new StringTokenizer(buffer.readLine()); 

            int opt= Integer.parseInt(tokens.nextToken());
            int a = Integer.parseInt(tokens.nextToken());


            if(opt==1){
                int b = Integer.parseInt(tokens.nextToken()); 
                //System.out.println(opt+" "+a+" "+b);
                //다음에 줄을 설차례인 b명의 줄을 만듭니다. 
                int insertHead = currentStudent; 
                //3
                for(int i=currentStudent; i<=currentStudent+b; i++){
                    students.put(i, new Node(i));
                }
                for(int i=currentStudent; i<currentStudent+b-1; i++){
                    students.put(i, new Node(i));
                    students.put(i+1, new Node(i+1));
                    connect(students.get(i),students.get(i+1));
                }
                currentStudent +=b; 
                int insertTail = currentStudent-1; 
                //a번 학생 뒤에 b명의 학생의 줄을 세웁니다. 
                insertNext(students.get(a), students.get(insertHead), students.get(insertTail)); 
                

            }else if(opt==2){
                int b = Integer.parseInt(tokens.nextToken()); 
                //System.out.println(opt+" "+a+" "+b);
                //다음에 줄을 설차례인 b명의 줄을 만듭니다. 
                
                int insertHead = currentStudent; 
                //3
                for(int i=currentStudent; i<=currentStudent+b; i++){
                    students.put(i, new Node(i));
                }
                for(int i=currentStudent; i<currentStudent+b-1; i++){
                    students.put(i, new Node(i));
                    students.put(i+1, new Node(i+1));
                    connect(students.get(i),students.get(i+1));
                }
                currentStudent +=b; 
                int insertTail = currentStudent-1; 
                //System.out.println(a+" "+insertHead+" "+insertTail);
                //a번 학생 뒤에 b명의 학생의 줄을 세웁니다. 
                insertPrev(students.get(a), students.get(insertHead), students.get(insertTail)); 


            }else if(opt==3){
                //System.out.println(opt+" "+a);
                result.append(students.get(a).print()).append("\n");

            }
        // System.out.println(); 
        // System.out.println(opt+" "+a);
        // for(int i=1; i<=currentStudent-1; i++){
        //     System.out.println(students.get(i).print()); 
        // }



        }
        System.out.println(result); 



        //1 
            //다음에 줄을 설 차례인 b명의 줄을 만듭니다. 
            //b명의 줄을 a번 학생 뒤에 세웁니다. 

    
        //2 
            //다음에 줄을 설 차례인 b명의 줄을 만듭니다. 
            //b명의 줄을 a번 학생 앞에 세웁니다. 

        //3 
            //a번 학생 앞과 뒤에 있는 학생의 번호를 찾기 


   

    }

    private static void insertNext(Node target,Node insertHead,Node insertTail){
        if(target.next!=null){
            target.next.prev = insertTail;
        }

        insertTail.next = target.next;
        target.next = insertHead;
 
        insertHead.prev = target; 
  
    }

    private static void insertPrev(Node target, Node insertHead, Node insertTail){
        if(target.prev!=null){
            target.prev.next = insertHead;
        }
    
        insertHead.prev = target.prev; 
     
        insertTail.next = target; 
        target.prev = insertTail;
     
    }

    private static void connect(Node s, Node e){
        if(s!=null)s.next = e;
        if(e!=null)e.prev = s; 
    }
}