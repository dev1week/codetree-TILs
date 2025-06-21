#include <iostream>
#include <vector>
using namespace std;

int get_offender(vector<int> & cost, int k, int m ){

    for(int query=0; query<m; query++){
        int student_num = 0;
        cin>>student_num; 

        cost[student_num]++;
        if(cost[student_num]>=k){
            return student_num; 
        }
    }
    return -1; 
}

int main() {

    int n,m,k;

    cin>>n>>m>>k; 

    vector<int> cost(n+1, 0); 


    cout<<get_offender(cost, k, m); 
    

    return 0;
}