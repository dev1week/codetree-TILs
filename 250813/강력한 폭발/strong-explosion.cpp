#include <iostream>
#include <vector> 
#include <algorithm> 
using namespace std;

const int dirs[3][4][2]= {
    {
        {2,0},
        {1,0},
        {-1,0},
        {-2,0}
    },
    {
        {1,0},
        {0,1},
        {0,-1},
        {-1,0}
    },
    {
        {-1,-1},
        {1,1},
        {-1,1},
        {1,-1}
    }
};
int result = 0; 

void print(vector<int>& bombs){
    for(int bomb: bombs){
        cout<<bomb<<" "; 
    }
    cout<<endl;
}

void print(int (&map)[20][20], int n){
    for(int x=0; x<n; x++){
        for(int y=0; y<n; y++){
            cout<<map[x][y]<<" ";
        }
        cout<<endl; 
    }
}

bool in_range(int x, int y, int n){
    return x>=0&&y>=0&&x<n&&y<n; 
}


void activate_bomb(int bomb, int (&after_destroy)[20][20], int n, int x, int y){
    after_destroy[x][y] = 1;
    //cout<<x<<" "<<y<<"일 때 "<<bomb<<"폭탄 터짐"<<endl;
    for(auto d: dirs[bomb]){
        int next_x = x+d[0];
        int next_y = y+d[1]; 
        if(in_range(next_x, next_y, n)){
            //cout<<next_x<<" "<<next_y<<endl; 
            after_destroy[next_x][next_y] = 1; 
        }
    }
}

int count(int (&after_destroy)[20][20], int n){
    int cnt = 0;
    for(int x=0; x<n; x++){
        for(int y=0; y<n; y++){
            cnt+= after_destroy[x][y]; 
        }
    }
    return cnt; 
}


int destroy(vector<int>& bombs, int (&grid)[20][20], int n){
    int after_destroy[20][20] ={0};
    int current_bomb = 0; 
    for(int x=0; x<n; x++){
        for(int y=0; y<n; y++){
            if(grid[x][y]==1){
                activate_bomb(bombs[current_bomb], after_destroy, n,x,y); 
                current_bomb++; 
            }
        }
    }
    //cout<<endl; 
    //print(bombs); 
    //print(after_destroy,n);

    return count(after_destroy, n);
}



void generate_sequence(vector<int>& bombs, int current, int (&grid)[20][20], int n){
    if(current==bombs.size()){

        result = max(result, destroy(bombs, grid, n));

        return; 
    }

    for(int next=0; next<3; next++){
        bombs[current] = next; 
        generate_sequence(bombs, current+1, grid, n); 
    }
}

int main() {
    int n; 
    cin >> n;

    int grid[20][20]; 
    int bomb_cnt = 0; 
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
            if(grid[i][j]==1) bomb_cnt++; 
        }
    }
    //1~3까지 중 중복을 허용하여 bomb_cnt길이의 순열을 생성 
        //순열을 다 뽑으면 초토화되는 지역 카운팅하기  
    
    vector<int> bombs(bomb_cnt, 0); 

    generate_sequence(bombs,0, grid, n); 

    cout<<result; 

    return 0;
}
