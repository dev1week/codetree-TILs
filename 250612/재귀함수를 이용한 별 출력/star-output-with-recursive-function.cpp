#include <iostream>

using namespace std;

int n;

void printStar(int n){
    if(n==0)return; 
    printStar(n-1);
    for(int i=0; i<n; i++){
        cout<<"*";
    }
    cout<<endl; 

}

int main() {
    cin >> n;

    // Please write your code here.

    printStar(n);

    return 0;
}