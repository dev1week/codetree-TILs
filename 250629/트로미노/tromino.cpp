#include <iostream>

using namespace std;

int n, m;
int grid[200][200];

const int blocks[6][3][3] = {
    {
        {1,0,0},
        {1,0,0},
        {1,0,0}
    }, 
    {
        {1,1,0}, 
        {0,1,0},
        {0,0,0}
    }, 
    {
        {1,0,0}, 
        {1,1,0}, 
        {0,0,0}
    }, 
    {
        {1,1,0}, 
        {1,0,0}, 
        {0,0,0}
    }, 
    {
        {1,1,1}, 
        {0,0,0}, 
        {0,0,0}
    }, 
    {
        {1,0,0}, 
        {1,1,0}, 
        {0,0,0}
    }
}; 

bool in_range(int x, int y){
    return x>=0&&y>=0&&x<n&&y<n;
}

int get_part_sum(int x,int y){
    int result = 0; 
    for(auto& block : blocks){
        int part_sum = 0; 
        for(int bX=0; bX<3; bX++){
            for(int bY=0; bY<3; bY++){
                if(in_range(x+bX,y+bY)&&block[bX][bY]==1){
                    part_sum += grid[x+bX][y+bY]; 
                }
            }
        }
        result = max(result, part_sum);   
    }
    return result; 
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
        }
    }
    int result = 0;
    for(int x=0; x<n; x++){
        for(int y=0; y<n; y++){
            //해당 위치에 블록을 놓았을 때 
            result = max(result, get_part_sum(x, y));
        }
    }
    cout<<result;
    return 0;
}
