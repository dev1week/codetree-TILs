#include <iostream>
#include <vector> 

using namespace std;

int N, M;
int v[1000], t[1000];
int v2[1000], t2[1000];
const int not_visited = 1000001; 
const int start = 0; 
const int A = 1;
const int B = 2; 

vector<int> get_point(int t[], int v[], int N){
    vector<int> position(not_visited, not_visited);
    position[0] = start;
    int total_time = 0; 
    for(int i=0; i<N; i++){
        for(int time=0; time<t[i]; time++){
            position[total_time+1] = position[total_time]+v[i];
            total_time++; 
        }
    } 
    return position; 
}

int get_cnt(const vector<int> & a_position, const vector<int> & b_position){
    int winner = 0; 
    int cnt = 0; 
    for(int time=1; time<not_visited; time++){
        if(a_position[time]==not_visited) return cnt; 

        if(a_position[time]>b_position[time]){
            if(winner==B){
                cnt++; 
            }
            winner = A; 
        }

        if(b_position[time]>a_position[time]){
            if(winner==A){
                cnt++; 
            }
            winner = B; 
        }
    }

    return cnt; 
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) cin >> v[i] >> t[i];

    for (int i = 0; i < M; i++) cin >> v2[i] >> t2[i];


    vector<int> a_position = get_point(t, v, N);
    vector<int> b_position= get_point(t2, v2, M); 


    cout<<get_cnt(a_position, b_position); 
    







    // Please write your code here.

    return 0;
}