#include <iostream>
#include <algorithm> 
using namespace std;

int N, H, T;
int arr[100];

int abs(int num){
    return num>0?num:(-1)*num; 
}

int main() {
    cin >> N >> H >> T;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    // Please write your code here.
    int result = 200001; 
    for(int start=0; start<N-T+1; start++){
        int part_cost = 0; 
        for(int offset=0; offset<T; offset++){
            part_cost += abs(arr[start+offset]-H); 
        }
        result = min(part_cost, result);
    }

    cout<<result; 

    return 0;
}