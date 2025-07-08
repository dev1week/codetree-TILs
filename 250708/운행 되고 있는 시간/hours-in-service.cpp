#include <iostream>
#include <algorithm> 
using namespace std;

int N;
int A[101], B[101];

int main() {
    cin >> N;


    int log[1001] = {};
    for (int i = 1; i <= N; i++) {
        cin >> A[i] >> B[i];
        for(int time=A[i]; time<=B[i]; time++){
            log[time] = i; 
        }
    }
    int result = 0; 
    for(int skip=1; skip<=N; skip++){
        int cnt = 0; 
        for(int time=1; time<=1000; time++){
            if(log[time]==skip)continue;
            if(log[time]>0)cnt++; 
        }

        result = max(cnt, result); 
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}