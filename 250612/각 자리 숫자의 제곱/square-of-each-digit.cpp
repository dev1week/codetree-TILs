#include <iostream>

using namespace std;

int N;

int square(int n){
    return n*n; 
}


int sum(int n){
    if(n<10){
        return square(n); 
    }

    return sum(n/10)+square(n%10);
}


int main() {
    cin >> N;


    cout<<sum(N); 
    // Please write your code here.

    return 0;
}