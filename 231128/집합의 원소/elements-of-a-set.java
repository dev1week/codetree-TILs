import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static final int UNION = 0;
    static final int CHECK = 1;
    
    //0이 나올 경우 합친다. 

    //1이 나올 경우 같은 집합에 있는지 확인한다. 

    static int n; // 정수의 개수 
    static int m; // 연산의 횟수 


    static int[] parents; 

    static int find(int a){
        if(a==parents[a]){
            return a; 
        }

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int pA = find(a);
        int pB = find(b); 

        parents[pA] = pB;
    }

    static void init() throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 
        n = Integer.valueOf(tokens.nextToken());
        m = Integer.valueOf(tokens.nextToken()); 
        
        parents = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	parents[i] = i;
        }
    }

    public static void main(String[] args)throws IOException{
        init(); 
        
        StringBuilder log = new StringBuilder();
        for(int i=0; i<m; i++) {
        	tokens = new StringTokenizer(buffer.readLine()); 
        	
        	int opt = Integer.valueOf(tokens.nextToken());
        	int a =Integer.valueOf(tokens.nextToken());
        	int b =Integer.valueOf(tokens.nextToken());
        	if(opt==UNION) {
        		union(a,b);
        	}else if(opt==CHECK) {
        		if(find(a)==find(b)) {
        			log.append(1).append("\n");
        		}else {
        			log.append(0).append("\n");
        		}
        	}

        }
      System.out.println(log);

    }
}