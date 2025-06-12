#include <iostream>

using namespace std;

int N;


int getNumberAt(int n){
    if(n<=2){
        return 2*n; 
    }

    return getNumberAt(n-1)*getNumberAt(n-2)%100; 

}
int main() {
    cin >> N;


    cout<<getNumberAt(N);
    // Please write your code here.

    return 0;
}