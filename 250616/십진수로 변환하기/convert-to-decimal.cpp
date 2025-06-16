#include <iostream>
#include <string> 
using namespace std;

string binary; 

int main() {
    cin >> binary;

    int offset = 1; 
    int result = 0; 
    for(int i=binary.size()-1; i>=0; i--){
        if(binary[i]=='1'){
            result+=offset; 
        }
        offset *=2; 
        //cout<<result<<endl;; 
    }

    cout<<result; 
    // Please write your code here.

    return 0;
}