#include <iostream>

using namespace std;

int ROW = 0;
int COL = 1; 

int n, m;
int grid[100][100];

void get_seq_by(int start, int axis, int seq[]){ 
    
    if(axis==ROW){
        for(int col=0; col<n; col++){
            seq[col] = grid[start][col]; 
        }    
    }else{
        for(int row=0; row<n; row++){
            seq[row] = grid[row][start]; 
        }    
    }
}

bool is_happy(int seq[]){
    int part_consecutive_cnt = 1; 
    int result_consecutive_cnt = 0; 

    for(int i=1; i<n; i++){
        if(seq[i-1]==seq[i]){
            part_consecutive_cnt++; 
        }else{
            part_consecutive_cnt = 1; 
        }
        result_consecutive_cnt = max(result_consecutive_cnt, part_consecutive_cnt); 
    }

    return result_consecutive_cnt>=m; 
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }
    
    int result = 0; 
    int seq[n] = {}; 

    for(int row=0; row<n; row++){
        get_seq_by(row, ROW, seq);
        if(is_happy(seq)){
            result++; 
        }
    }
    for(int col=0; col<n; col++){
        get_seq_by(col, COL, seq); 
        if(is_happy(seq)){
            result++; 
        }
    }

    cout<<result; 

    

    return 0;
}
