#include <iostream>
#include <string>
#include <algorithm> 

using namespace std;

int n, k;
string t;
string str[100];
string words[100]; 

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
    string data; 
    for (int i = 0; i < n; i++) {
        cin >> str[i];
        if(startsWith(str[i], t)){
            words[idx++] = str[i];
        }
    }

    sort(words, words+idx); 
    cout<<words[k-1]; 

    // Please write your code here.

    return 0;
}