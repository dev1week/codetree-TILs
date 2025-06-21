#include <iostream>
#include <vector> 
using namespace std;
int not_visited = 10000001; 


void input(int time[], char dir[], int n){
    for(int i=0; i<n; i++){
        cin>>dir[i]>>time[i];
    }
}

vector<int> get_position(int time[], char dir[], int n){
    //시간별 a의 위치 저장하기 
    vector<int> position(not_visited,not_visited);
    position[0] = 0; 
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

int get_meeting_time(const vector<int>& position_a, const vector<int>& position_b){
    for(int time=1; time<=not_visited; time++){
        if(position_a[time]==not_visited||position_b[time]==not_visited){
            return -1; 
        }
        if(position_a[time]==position_b[time]){
            return time; 
        }

    }

    return -1; 
}

int main() {
    int n, m; 

    cin>>n>>m; 


    int time_a[1001] = {};
    char dir_a[1001] = {}; 

    int time_b[1001] = {};
    char dir_b[1001] = {}; 

    input(time_a, dir_a, n); 
    input(time_b, dir_b, m); 


    vector<int> position_a = get_position(time_a, dir_a, n); 
    vector<int> position_b = get_position(time_b, dir_b, m);


    cout<<get_meeting_time(position_a, position_b);

}