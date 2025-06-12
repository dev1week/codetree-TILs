#include <iostream>

using namespace std;

int N;

int factorial(int n){
    if(n==1){
        return 1; 
    }

    return n*factorial(n-1); 
}

int main() {
    cin >> N;
    

    cout<<factorial(N); 
    // Please write your code here.

    return 0;
}