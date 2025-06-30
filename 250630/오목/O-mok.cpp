#include <iostream>

using namespace std;

int board[19][19];

const int BLACK = 1;
const int WHITE = 2;

bool in_range(int x, int y){
    return x>=0&&x<19&&y>=0&&y<19; 
}

bool is_winner(int x, int y, int& winner_x, int& winner_y){

    // cout<<x<<":"<<y<<endl; 
    //가로로 확인 
    int consecutive_cnt = 1; 
    for(int offset=1; offset<5; offset++){
        if(y+offset<19&&board[x][y+offset-1]==board[x][y+offset]){
            consecutive_cnt++; 
        }
    }

    // cout<<"가로로 확인 "<<consecutive_cnt<<endl; 

    if(consecutive_cnt==5){
        winner_x = x;
        winner_y = y+2; 
        return true; 
    }

    consecutive_cnt = 1; 
    for(int offset=1; offset<5; offset++){
        if(x+offset<19&&board[x+offset-1][y]==board[x+offset][y]){
            consecutive_cnt++; 
        }
    }
    // cout<<"세로로 확인 "<<consecutive_cnt<<endl; 


    if(consecutive_cnt==5){
        winner_x = x+2;
        winner_y = y; 
        return true; 
    }


    consecutive_cnt = 1; 
    for(int offset=1; offset<5; offset++){
        if(x+offset<19&&y+offset<19&&board[x+offset-1][y+offset-1]==board[x+offset][y+offset]){
            consecutive_cnt++; 
        }
    }

    if(consecutive_cnt==5){
        // cout<<"` 대각선으로 확인 "<<consecutive_cnt<<endl; 

        winner_x = x+2;
        winner_y = y+2; 
        return true; 
    }

    consecutive_cnt = 1; 
    for(int offset=1; offset<5; offset++){
        if(in_range(x+offset-1, y-offset+1)&&in_range(x+offset, y-offset)&&board[x+offset-1][y-offset+1]==board[x+offset][y-offset]){
            consecutive_cnt++; 
        }
    }

    if(consecutive_cnt==5){
        // cout<<"/ 대각선으로 확인 "<<consecutive_cnt<<endl; 

        winner_x = x+2;
        winner_y = y-2; 
        return true; 
    }

    return false; 


}

void find(int & winner, int & winner_x, int & winner_y){
    for(int x=0; x<19; x++){
        for(int y=0; y<19; y++){
            if(board[x][y]==0)continue; 
            //연속으로 5번일 경우 해당 칸으로 
            if(is_winner(x, y, winner_x, winner_y)){
                winner = board[x][y];

                return; 
            }
        }
    }
}



int main() {
    for (int i = 0; i < 19; i++)
        for (int j = 0; j < 19; j++) cin >> board[i][j];

    
    int winner = 0;
    int winner_x = 0;
    int winner_y = 0; 

    find(winner, winner_x, winner_y);

    cout<<winner<<endl;
    if(winner!=0){
        cout<<winner_x+1<<" "<<winner_y+1<<endl;
    }

    return 0;
}