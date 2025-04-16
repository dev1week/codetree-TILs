import java.util.*;
import java.io.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    private final static int MAX_NUM= 11; 
    private static boolean isPossible = false; 
    private static final TrieNode ROOT = new TrieNode(); 

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(buffer.readLine());

        for(int i=0; i<n; i++){
            String s = buffer.readLine(); 

            insertAndFind(s); 

        }

        System.out.println(isPossible==true?0:1);
    }

    private static void insertAndFind(String s){
        TrieNode cur = ROOT; 

        for(int sIdx=0; sIdx<s.length(); sIdx++){
            if(cur.isEnd == true&&sIdx!=s.length()-1){
                    //System.out.println(s+"는 아직 넣어야할 데이터가 있는데");
                    isPossible = true; 
            }

            int num = c2i(s.charAt(sIdx)); 

            if(cur.child[num]==null){
                cur.child[num] = new TrieNode(); 
            }
            cur = cur.child[num]; 
        }

        cur.isEnd = true; 

        for(TrieNode ch: cur.child){
            if(ch!=null) isPossible = true; 
        }
    }

    private static int c2i(char c){
        return c-'0'; 
    }

    //넣을 때 Trie에 넣으면서 접두사가 되는 문자가 있는지 확인한다. 
}

class TrieNode{
    TrieNode[] child = new TrieNode[11]; 
    boolean isEnd; 

    TrieNode(){
        isEnd = false; 
    }
}