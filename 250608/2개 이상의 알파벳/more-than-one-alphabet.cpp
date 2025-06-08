#include <iostream>
#include <string>

using namespace std;

string A;


bool isValid(string &s){

    for(int i=1; i<s.length(); i++ ){
        if(s[i-1]!=s[i]){
            return true; 
        }
    }
    return false; 
}

int main() {
    cin >> A;


    if(isValid(A)){
        cout<<"Yes";
    }else{
        cout<<"No"; 
    }
    // Please write your code here.

    return 0;
}