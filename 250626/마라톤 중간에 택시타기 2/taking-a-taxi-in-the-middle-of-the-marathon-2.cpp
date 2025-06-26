#include <iostream>
#include <vector> 
using namespace std;

int n;
int x[100];
int y[100];
int get_d(int c, int o){
    return c>o?(c-o):(o-c);
};
class Point{
    private: 
        int x, y;
    
    public:
        Point(int x, int y){
            this-> x = x;
            this-> y = y; 
        }

        int get_dist(Point o){
            return get_d(x, o.x)+get_d(y, o.y);
        }
};




int main() {
    cin >> n;

    int total_dist = 0;

    vector<Point> points; 
    for (int i = 0; i < n; i++) {
        int x, y;
        cin>>x>>y; 
        points.push_back(Point(x,y));

        if(i>0&&i<n){
            total_dist += points[i].get_dist(points[i-1]);
        }
    }

    int result = total_dist; 
    //스킵할 장소 구하기 
    for(int skip=1; skip<n-1; skip++){
        //스킵한 기준 전체 거리 다시 구하기 
        int new_dist =total_dist 
                        - points[skip-1].get_dist(points[skip])
                        - points[skip].get_dist(points[skip+1])
                        + points[skip-1].get_dist(points[skip+1]);
        //전체거리 - (스킵포인트-1, 스킵포인트)-(스킵포인트+1, 스킵포인트)+(스킵포인트+1, 스킵포인트-1);
        if(new_dist<result)result = new_dist; 
    }
    cout<<result; 
    return 0;
}