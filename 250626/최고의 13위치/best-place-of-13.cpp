#include <iostream>

using namespace std;

int N;
int grid[20][20];

bool in_range(int x, int y, int n){
    return x>=0&&y>=0&&x<n&&y<n; 
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) cin >> grid[i][j];

    int result = 0; 
    for(int x=0; x<N; x++){
        for(int y=0; y<=N-3; y++){
            int partSum = 0; 

            for(int offset=0; offset<3; offset++){
                partSum += grid[x][y+offset]; 
            }
            
            if(partSum>result) result = partSum;
        }
    }
    cout<<result; 
    return 0;
}