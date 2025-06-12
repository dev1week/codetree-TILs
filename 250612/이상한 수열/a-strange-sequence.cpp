#include <iostream>

using namespace std;

int N;

int getNumberAt(int n){
    if(n<=2){
        return n;
    }

    return getNumberAt(n/3)+getNumberAt(n-1); 
}

int main() {
    cin >> N;

    cout<<getNumberAt(N);
    // Please write your code here.

    return 0;
}