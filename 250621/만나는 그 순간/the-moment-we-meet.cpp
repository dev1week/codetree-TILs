#include <iostream>
#include <vector> 
using namespace std;
int not_visited = 10000; 


void input(int time[], char dir[], int n){
    for(int i=0; i<n; i++){
        cin>>dir[i]>>time[i];
    }
}

vector<int> get_position(int time[], char dir[], int n){
    //시간별 a의 위치 저장하기 
    vector<int> position(1001, not_visited);
    int total_time = 0; 
    int current_position = 0; 
    for(int i=0; i<n; i++){
        int end = time[i]; 
        int d = dir[i]=='L'?-1:1; 
        for(int t=1; t<=end; t++){
            total_time++; 
            current_position += (d); 
            position[total_time] = current_position; 
        }
    }


    return position; 
    
}

int get_meeting_time(vector<int> position_a, vector<int> position_b){

    for(int time=1; time<=1000; time++){
        if(position_a[time]==position_b[time]){
            return time; 
        }
    }

    return -1; 
}

int main() {
    int n, m; 

    cin>>n>>m; 


    int time_a[n] = {};
    char dir_a[n] = {}; 

    int time_b[m] = {};
    char dir_b[m] = {}; 

    input(time_a, dir_a, n); 
    input(time_b, dir_b, m); 


    vector<int> position_a = get_position(time_a, dir_a, n); 
    vector<int> position_b = get_position(time_b, dir_b, m);

    cout<<get_meeting_time(position_a, position_b);

}