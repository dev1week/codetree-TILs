#include <iostream>

using namespace std;

int N;

void print(int n){
    if(n==N){
        return; 
    }
    cout<<"HelloWorld"<<endl;
    print(n+1);
}

int main() {
    cin >> N;


    print(0);
    // Please write your code here.

    return 0;
}