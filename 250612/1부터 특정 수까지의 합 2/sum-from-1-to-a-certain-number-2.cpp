#include <iostream>

using namespace std;

int N;

int sum(int n){
    if(n==1){
        return 1; 
    }

    return sum(n-1)+n; 
}

int main() {
    cin >> N;


    cout<<sum(N); 
    // Please write your code here.

    return 0;
}