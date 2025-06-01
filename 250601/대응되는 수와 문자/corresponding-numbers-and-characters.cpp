#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int n, m;
string words[100000];
string queries[100000];

int main() {
    unordered_map<string, int> map; 

    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> words[i];
        map[words[i]] = i; 
    }

    for (int i = 0; i < m; i++) {
        cin >> queries[i];
        if('0' <= queries[i][0] && queries[i][0] <= '9'){
            cout<<words[stoi(queries[i])]<<endl;
        }else{
            cout<<map[queries[i]]<<endl;
        }
    }

    // Please write your code here.

    return 0;
}
