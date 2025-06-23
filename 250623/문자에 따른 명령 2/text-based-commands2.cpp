#include <iostream>

using namespace std;

string dirs;

const int X = 0;
const int Y = 1; 

class Point{
    private:
        int x, y, dir; 
        int d[4][2] ={
            {1,0}, 
            {0,1},
            {-1,0},
            {0,-1}
        }; 

    public:
        Point(int x, int y){
            this-> x=x;
            this->y=y; 
            this->dir = 0; 
        }

        void turn_right(){
            dir++; 
            if(dir>3){
                dir = 0; 
            }
        }

        void turn_left(){
            dir--;
            if(dir<0){
                dir = 3;  
            } 
        }

        void move(){
            x += d[dir][X];
            y += d[dir][Y]; 
        }

        void print(){
            cout<<y<<" "<<x;  
        }

};

int main() {
    cin >> dirs;

    Point current(0,0); 

    for(int i=0; i<dirs.length(); i++){
        if(dirs[i]=='L'){
            current.turn_left();
        }else if(dirs[i]=='R'){
            current.turn_right(); 
        }else{
            current.move(); 

        }
    }
    current.print(); 


    
    // Please write your code here.

    return 0;
}