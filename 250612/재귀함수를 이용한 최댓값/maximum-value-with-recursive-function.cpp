#include <iostream>

using namespace std;

int n;
int arr[100];

int result = 0; 

int max(int current, int arr[]){
    if(current==0){
        return arr[0];
    }
    int partMax = max(current-1, arr); 
    return arr[current]>partMax?arr[current]:partMax;
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout<<max(n-1, arr); 

    return 0;
}