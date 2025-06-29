#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;

    int cnt = 0; 
    for(int i=0; i<A.length()-1; i++){
        if(A[i]=='('&&A[i+1]=='('){
            for(int j=i+2; j<A.length()-1; j++){
                if(A[j]==')'&&A[j+1]==')'){
                    cnt++;
                }
            }
        }   
    }
    

    cout<<cnt; 

    return 0;
}