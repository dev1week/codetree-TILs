#include <iostream>

using namespace std;

int a, b;

void apply(int &a, int &b){

    if(a>b){
        a += 25; 
        b *=2; 
    }else{
        a *=2; 
        b +=25; 
    }

}

int main() {
    cin >> a >> b;


    apply(a,b); 

    cout<<a<<" "<<b; 
    // Please write your code here.

    return 0;
}