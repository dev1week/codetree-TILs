import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> seats = new TreeSet<>(); 
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int seat=1; seat<=n; seat++){
            seats.add(seat);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            int want = arr[i]; 
            //같거나 작은 최댓값이 존재한다면 
            if(seats.floor(want)!=null){
                int seat = seats.floor(want); 
                seats.remove(seat); 
                ans++; 
            }else{
                break; 
            }

        }

        System.out.println(ans); 
        
        // Please write your code here.
    }
}