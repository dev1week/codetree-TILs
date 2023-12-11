import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static int n;
    static int m;
    static int[] numbers;
    
    
    
    static void init() throws IOException{
    	tokens = new StringTokenizer(buffer.readLine());
    	n = Integer.valueOf(tokens.nextToken());
    	m = Integer.valueOf(tokens.nextToken());
    	numbers = new int[n];
    	
    	
    	for(int i=0; i<n; i++) {
    		numbers[i] = Integer.valueOf(buffer.readLine());
    	}
    	
    }
     
    public static void main(String[] args) throws IOException{
    	//원래 문제 : n개의 정수를 분배해 같은 크기의 정수 k를 m개 만들수 있는 k의 최대 
    	//결정 문제 : K=10일 때, n개의 정수를 분배해 같은 크기의 정수 K를 M개 만들 수 있는가?
    	
    	
    	init();
        int left = 1;                          // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        int right = 100000;                        // 답이 될 수 있는  가장 큰 숫자 값을 설정합니다.
        int ans = 0;                     // 최소이므로, 초기값을 INT_MAX로 설정합니다.
        
        while (left <= right) {                // [left, right]가 유효한 구간이면 계속 수행합니다.
            int mid = (left + right) / 2;      // 가운데 위치를 선택합니다.
            if(isPossible(mid)) {              // 결정문제에 대한 답이 Yes라면
                left= mid+1;             // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
                ans = Math.max(ans, mid);      // 답의 후보들 중 최솟값을 계속 갱신해줍니다.
            }
            else                               
                right=mid-1;               // 결정문제에 대한 답이 No라면 left를 바꿔줍니다.
        }

        System.out.print(ans);
    }
    
	//원래 문제 : n개의 정수를 분배해 같은 크기의 정수 k를 m개 만들수 있는 k의 최대 
	//결정 문제 : K=10일 때, n개의 정수를 분배해 같은 크기의 정수 K를 M개 만들 수 있는가?

	static boolean isPossible(int k) {
		int totCount = 0;
		
		for(int number : numbers) {
			totCount += number/k;
		}
		
		return m<=totCount;
		
		
	}
		
    

	
}