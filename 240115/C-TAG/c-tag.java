import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    
    static int n; 
    static int m; 

    static int[] selecteds; 
    static boolean[] isUsed; 
    static int result; 

    static String[] a; 
    static String[] b; 

    static void init() throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        n = Integer.valueOf(tokens.nextToken());
        m = Integer.valueOf(tokens.nextToken()); 

        result = 0; 
        isUsed = new boolean[m];
        selecteds = new int[3]; 
        result = 0; 
        a = new String[n];
        b = new String[n];

        for(int i=0; i<n; i++){
            a[i] = buffer.readLine();
        }

        for(int i=0; i<n; i++){
            b[i] = buffer.readLine(); 
        }

    }

    static boolean isIntersetcB(Set dictionary){
        for(int i=0; i<n; i++){
            String key ="";
            for(int idx : selecteds){
                key+=b[i].charAt(idx);
            }
            if(dictionary.contains(key)){
                return true; 
            }
        }

        return false;
    }
    
    static void bt(int cur, int last){
        if(cur==3){
            //System.out.println(Arrays.toString(selecteds)); 
            Set<String> dictionary = new HashSet<>(); 
            for(int i=0; i<n; i++){
                String key="";
                for(int idx : selecteds){
                    key+=a[i].charAt(idx);
                }
                dictionary.add(key);
            }
            //System.out.println(dictionary); 
            if(!isIntersetcB(dictionary)){
                //System.out.println("성공"); 
                result++; 
            }

            return; 
        }

        for(int i=last+1; i<m; i++){
            if(!isUsed[i]){
                isUsed[i]= true; 
                selecteds[cur] = i;
                bt(cur+1, i); 
                isUsed[i] = false; 
            }
        }

    }

    public static void main(String[] args) throws IOException{
        init(); 

        bt(0, -1); 

        System.out.println(result); 
        //m개의 인덱스 중 3개를 뽑는 경우의 수를 구함 
            //300개 문자열 순회 
                // 뽑은 인덱스로 key 생성하여 해쉬에 넣기 
            //나머지 300개에 대해 해시에 있는지 확인하기 
                //전부 없을 경우 카운트 증가 
            
    }
}