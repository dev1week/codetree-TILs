import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //문제의 갯수 10^5 
        
        TreeSet<Problem> problems = new TreeSet<>(); 
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            problems.add(new Problem(p,l)); 
        }
        int m = sc.nextInt();


        //System.out.println(problems); 
        
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();

                if(x==1){
                    //문제 난이도가 가장 높은 문제번호 출력 
                        //난이도가 같을 경우 문제번호가 큰 것 
                    System.out.println(problems.last());
                }else{
                    //문제 난이도가 가장 낮은 문제 번호 출력 
                        //난이도가 같을 경우 문제 번호가 작은 것 
                    System.out.println(problems.first());
                }

            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                if(command.equals("ad")){
                    //문제 번호 P번에 난이도 L인 문제 추가 
                    //동일 문제 번호 다른 난이도 추가 가능 
                    problems.add(new Problem(p, l));
                }else{
                    //문제 번호 p번에 난이도l인 문제 제거 
                    problems.remove(new Problem(p,l));
                }
            }
        }
        // Please write your code here.

        //System.out.println(problems); 
    }
}

class Problem implements Comparable<Problem>{
    int idx, difficulty;

    public Problem(int idx, int difficulty){
        this.idx = idx;
        this.difficulty = difficulty; 
    }

    @Override 
    public int compareTo(Problem o){
        if(this.difficulty==o.difficulty){
            return this.difficulty-o.difficulty; 
        }
        return this.difficulty - o.difficulty;
    }

    @Override 
    public String toString(){
        return String.valueOf(this.idx); 
    }
}