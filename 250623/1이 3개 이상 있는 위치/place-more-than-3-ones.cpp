#include <iostream>

using namespace std;

int n;
int grid[100][100];

const int dir[4][2] = {
    {1,0}, 
    {-1, 0},
    {0,1},
    {0,-1}
};

bool in_range(int x, int y, int n){
    return x>=0&&y>=0&&x<n&&y<n; 
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }
    int result = 0; 
    for(int x=0; x<n; x++){
        for(int y=0; y<n; y++){
            int cnt = 0; 
            for(int d=0; d<4; d++){
                int nx = x + dir[d][0];
                int ny = y + dir[d][1]; 
                if(in_range(nx, ny, n)&&grid[nx][ny]==1){
                    cnt++; 
                }
            }
            if(cnt>=3){
                result++; 
            }
        }
    }

    cout<<result; 
    // Please write your code here.

    return 0;
}