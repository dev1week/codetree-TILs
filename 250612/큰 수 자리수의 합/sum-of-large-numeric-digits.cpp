#include <iostream>

using namespace std;

int a, b, c;

int sum(int n){
    if(n<10){
        return n; 
    }

    return (n%10)+sum(n/10); 
}

int main() {
    cin >> a >> b >> c;

    // Please write your code here.

    cout<<sum(a*b*c); 

    return 0;
}