#include <iostream>
#include <algorithm> 
using namespace std;

int max(int blocks[], int n){
    int result = 0; 
    for(int i=1; i<=n; i++){
        if(result<blocks[i]){
            result = blocks[i]; 
        }
    }
    return result; 
}

int main() {
    int N, K;
        
    cin >> N >> K;

    int blocks[N+1]={}; 
    int start[K], end[K];

    for (int i = 0; i < K; i++) {
        cin >> start[i] >> end[i];
        for(int place=start[i]; place<=end[i]; place++){
            blocks[place]++; 
        }
    }


    cout<<max(blocks, N);

    // Please write your code here.

    return 0;
}