#include <iostream>
#include <algorithm> 

using namespace std;

int n, m;
int grid[100][100];

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }
    int result = 0; 
    // cout<<"행검사"<<endl;
    for(int row=0; row<n; row++){
        int prev_num = grid[row][0]; 
        int cnt = 1; 
        int max_cnt = 0; 
        for(int col=1; col<n; col++){
            //연속한 경우 
            if(prev_num==grid[row][col]){
                cnt++;    
            }
            //연속이 깨진 경우 
            else{
                cnt = 1; 
            }
            max_cnt = max(max_cnt, cnt);
            prev_num = grid[row][col];
        }

        if(max_cnt>=m) result++; 
    }

    
    // cout<<"열검사"<<endl;
    for(int col=0; col<n; col++){
        int prev_num = grid[0][col]; 
        int cnt = 1; 
        int max_cnt = 0; 
        bool is_happy = false; 
        for(int row=1; row<n; row++){
            //연속한 경우 
            if(prev_num==grid[row][col]){
                cnt++; 
            }
            //연속이 깨진 경우 
            else{
                cnt = 1; 
            }
            max_cnt = max(max_cnt, cnt);
            prev_num = grid[row][col];
        }
        if(max_cnt>=m) result++; 
    }

    cout<<result;

    return 0;
}
