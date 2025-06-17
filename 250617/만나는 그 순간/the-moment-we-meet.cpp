#include <iostream>

using namespace std;
int not_visited = 10000; 

void get_log(char dir[], int time[], int n, int logs[]){    
    int total_time = 0; 
    int current_position = 0; 
    for(int i=0; i<n; i++){
        for(int t=1; i<=time[i]; t++){
            total_time++;
            int d = dir[i]=='L'?-1:1; 
            logs[total_time] = current_position+d; 
        } 
    }
}

int get_meet_time(int a_logs[], int b_logs[]){
    for(int time=1; time<=1000; time++){
        if(a_logs[time]==not_visited||b_logs[time]==not_visited){
            return -1; 
        }
        if(a_logs[time]==b_logs[time]){
            return time; 
        }
    }
    return -1; 
}

int main() {
    int n, m;
    char d[1000]={};
    int t[1000]={};
    char d2[1000]={};
    int t2[1000]={};
    cin >> n >> m;

    for (int i = 0; i < n; i++) cin >> d[i] >> t[i];

    for (int i = 0; i < m; i++) cin >> d2[i] >> t2[i];

    int a_logs[1001] = {not_visited};
    int b_logs[1001] = {not_visited};
    
    int total_time = 0; 
    int current_position = 0; 
    for(int i=0; i<n; i++){
        for(int time=1; i<=t[i]; time++){
            total_time++;
            int dir = d[i]=='L'?-1:1; 
            a_logs[total_time] = current_position+dir; 
        } 
    }

    total_time = 0; 
    current_position = 0; 
    for(int i=0; i<m; i++){
        for(int time=1; i<=t2[i]; time++){
            total_time++;
            int dir = d2[i]=='L'?-1:1; 
            b_logs[total_time] = current_position+dir; 
        } 
    }

    int meet_time = get_meet_time(a_logs, b_logs);
    

    return 0;
}