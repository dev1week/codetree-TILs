#include <iostream>

using namespace std;

int N;
int A[100];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    int cnt=0; 
    for(int i=0; i<N-2; i++){
        for(int j=i+1; j<N-1; j++){
            for(int k=j+1; k<N; k++){
                if(A[i]<=A[j]&&A[i]<=A[k]&&A[j]<=A[k]) cnt++; 
            }
        }
    }

    cout<<cnt; 

    // Please write your code here.

    return 0;
}