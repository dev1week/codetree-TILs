#include <iostream>

using namespace std;

int n;

void print(int n){
    if(n==0)return; 

    for(int i=0; i<n; i++){
        cout<<"* ";
    }
    cout<<endl; 
    print(n-1);
    for(int i=0; i<n; i++){
        cout<<"* ";
    }
    cout<<endl; 

}

int main() {
    cin >> n;

    // Please write your code here.
    print(n);
    return 0;
}