#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int n;
string words[100000];

int main() {
    unordered_map<string, int> cnt; 
    cin >> n;
    int result = 0; 
    for (int i = 0; i < n; i++) {
        cin >> words[i];

        if(cnt.find(words[i])==cnt.end()){
            cnt[words[i]] = 1; 
        }else{
            cnt[words[i]]++; 
        }

        if(result<cnt[words[i]]){
            result = cnt[words[i]];
        }

    }

    cout << result; 

    // Please write your code here.

    return 0;
}
