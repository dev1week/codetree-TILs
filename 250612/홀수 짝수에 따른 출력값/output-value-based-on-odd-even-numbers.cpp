#include <iostream>

using namespace std;

int N;

int sumEven(int n){
    if(n==2){
        return 2; 
    }

    return sumEven(n-2)+n;
}

int sumOdd(int n){
    if(n==1){
        return 1; 
    }

    return sumOdd(n-2)+n; 
}

int main() {
    cin >> N;

    if(N%2==0){
        cout<<sumEven(N);
    }else{
        cout<<sumOdd(N); 
    }
    return 0;
}