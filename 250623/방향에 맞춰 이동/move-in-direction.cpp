#include <iostream>

using namespace std;

int n;
char dir[100];
int dist[100];

const int d[4][2] = {
    {1,0},
    {-1,0},
    {0,1},
    {0,-1}
};

const int N = 0;
const int S = 1;
const int E = 2;
const int W = 3; 

class Point{
    private :
        int x, y; 
    public:
        Point(int x, int y){
            this->x=x;
            this->y=y; 
        }
        int get_x(){
            return x; 
        }
        int get_y(){
            return y; 
        }
        void set_x(int x){
            this-> x= x;
        }
        void set_y(){
            this-> y=y; 
        }

        void move(int dx, int dy){
            x += dx; 
            y+=dy; 
        }

        void print(){
            cout<<y<<" "<<x; 
        }

};

int get_dir(char dir, int axis){
        if(dir=='N'){
            return d[N][axis]; 
        }else if(dir=='S'){
            return d[S][axis]; 
        }else if(dir=='W'){
            return d[W][axis]; 
        }else if(dir=='E'){
            return d[E][axis]; 
        }

        return 0; 
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> dir[i] >> dist[i];
    }
    
    Point current(0,0); 

    for(int i=0; i<n; i++){
        int dx = get_dir(dir[i], 0);
        int dy = get_dir(dir[i],1);

        current.move(dx*dist[i], dy*dist[i]); 
    }

    current.print(); 
    return 0;
}