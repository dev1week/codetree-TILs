#include <iostream>
#include <string>
#include <algorithm> 

using namespace std;

int n, k;
string t;
string str[100];


bool startsWith(string data, string pattern){
    if(data.size()<pattern.size())return false; 

    for(int i=0; i<pattern.size(); i++){
        if(data[i]!=pattern[i])return false; 
    }

    return true; 

}

int main() {
    cin >> n >> k >> t;
    int idx = 0;
    for (int i = 0; i < n; i++) {
        string data; 
        cin >> data;
        if(startsWith(data, t)){
            str[idx] = data; 
            idx++; 
            cout<<data; 
            cout<<str[idx]<<endl;  
        }
    }

    sort(str, str+n); 

    cout<<str[k-1]; 

    // Please write your code here.

    return 0;
}