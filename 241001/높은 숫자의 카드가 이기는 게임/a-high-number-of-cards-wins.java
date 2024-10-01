import java.io.*;
import java.util.*; 
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    public static void main(String[] args) throws IOException{
        int n  = Integer.parseInt(buffer.readLine());
        
        List<Integer> aCards = new ArrayList<>(); 
        List<Integer> bCards = new ArrayList<>(); 


        boolean[] isACards = new boolean[2*n+1]; 

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(buffer.readLine());

            aCards.add(num);
            isACards[num] = true; 
        }

        for(int card=1; card<=2*n; card++){
            if(!isACards[card]){
                bCards.add(card);
            }
        }

        Collections.sort(aCards);
        Collections.sort(bCards);

        int lastBIdx = 0; 
        int cnt = 0; 
        

        for(int aCard : aCards){
            if(lastBIdx<n&&aCard>bCards.get(lastBIdx)){
                //System.out.println(bCards.get(lastBIdx)+" "+aCard);
                cnt++; 
                lastBIdx++; 
            }
        }

        System.out.println(cnt);

    }
}