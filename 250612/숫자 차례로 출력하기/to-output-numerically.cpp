#include <iostream>
using namespace std;

int N;

void printDescend(int n){
    if(n==0)return; 
    cout<<n<<" "; 
    printDescend(n-1);
}

void printAscend(int n){
    if(n==0)return; 
    printAscend(n-1);
    cout<<n<<" ";
}


int main() {
    cin>>N;
    printAscend(N);
    cout<<endl;
    printDescend(N);
    // Please write your code here.
    return 0;
}