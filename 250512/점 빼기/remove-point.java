import java.util.*; 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Point> points  = new TreeSet<>(); 

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt(); 

            points.add(new Point(x,y));
        }
        //System.out.println(points); 
        for(int i=0; i<m; i++){
            int x = sc.nextInt(); 
            Point searchPoint = new Point(x,-1);
            Point removedPoint = points.ceiling(searchPoint);
            if(removedPoint!=null){
                System.out.println(removedPoint);
                points.remove(removedPoint);
            }else{
                System.out.println("-1 -1");
            }
        }



    }
}

class Point implements Comparable<Point>{
    int x, y; 

    public Point(int x, int y){
        this.x =x;
        this.y = y; 
    }

    @Override 
    public int compareTo(Point o){
        if(this.x==o.x){
            return this.y-o.y; 
        }
        return this.x-o.x;
    }

    @Override 
    public String toString(){
        return this.x+" "+this.y; 
    }



}