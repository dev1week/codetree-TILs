#include <iostream>
#include <algorithm> 
using namespace std;

int N;
int A[101], B[101];

void change_log(int start, int end, int log[], int d){
    for(int time=start; time<end; time++){
        log[time]+=d; 
    }
}

int main() {
    cin >> N;


    int log[1001] = {};
    for (int i = 1; i <= N; i++) {
        cin >> A[i] >> B[i];
        change_log(A[i], B[i], log, 1); 
    }



    int result = 0; 
    for(int skip=1; skip<=N; skip++){
        int cnt = 0; 
        change_log(A[skip], B[skip],log, -1); 
        for(int time=1; time<=1000; time++){
            if(log[time]>0)cnt++; 
        }
        change_log(A[skip], B[skip],log, 1); 
        result = max(cnt, result); 
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}