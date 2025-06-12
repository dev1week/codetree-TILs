#include <iostream>

using namespace std;

int N;

int getCnt(int n){
    if(n==1){
        return 0; 
    }

    if(n%2==0){
        return getCnt(n/2)+1; 
    }else{
        return getCnt(n/3)+1; 
    }
}

int main() {
    cin >> N;
    cout<<getCnt(N); 
    // Please write your code here.

    return 0;
}