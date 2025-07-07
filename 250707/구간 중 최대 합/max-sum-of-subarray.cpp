#include <iostream>
#include <algorithm> 
using namespace std;

int n, k;
int arr[100];

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }


    int result = 0; 
    for(int i=0; i<n-k+1; i++){
        int part_sum = 0; 
        for(int offset=0; offset<k; offset++){
            part_sum += arr[i+offset];
        }
        cout<<endl; 
        result = max(part_sum, result);
    }

    cout<<result; 

    return 0;
}