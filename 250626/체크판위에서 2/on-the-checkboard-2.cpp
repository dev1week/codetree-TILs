#include <iostream>

using namespace std;

int R, C;
char grid[15][15];

const char B = 'B';
const char W = 'W'; 


int main() {
    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> grid[i][j];
        }
    }

    int cnt = 0; 
    for(int x1=1; x1<R-1; x1++){
        for(int y1=1; y1<C-1; y1++){
            for(int x2=x1+1; x2<R-1; x2++){
                for(int y2=y1+1; y2<C-1; y2++){
                    if(grid[0][0]!=grid[x1][y1]&&grid[x1][y1]!=grid[x2][y2]&&grid[x2][y2]!=grid[R-1][C-1])cnt++;
                }
            }

        }
    }

    cout<<cnt; 
    // Please write your code here.

    return 0;
}