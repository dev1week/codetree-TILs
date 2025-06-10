#include <iostream>
#include <string>
#include <algorithm> 
using namespace std;

string word1;
string word2;

bool isSame(string word1, string word2, int n){
    for(int i=0; i<n; i++){
        if(word1[i]!=word2[i]){
            return false; 
        }
    }

    return true; 

}

int main() {
    cin >> word1;
    cin >> word2;

    sort(word1.begin(), word1.end()); 
    sort(word2.begin(), word2.end()); 

    if(isSame(word1, word2, word1.size())){
        cout<<"Yes";
    }else{
        cout<<"No";
    }

    // Please write your code here.

    return 0;
}
