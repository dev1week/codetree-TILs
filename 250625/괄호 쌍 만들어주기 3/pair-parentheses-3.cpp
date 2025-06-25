#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;
    
    int cnt =0;

    for(int start=0; start<A.length()-1; start++){
        for(int end=start+1; end<A.length(); end++){
            if(start==end)continue;
            if(A[start]=='('&&A[end]==')'){
                cnt++; 
            } 
        }
    }

    cout<<cnt; 

    return 0;
}