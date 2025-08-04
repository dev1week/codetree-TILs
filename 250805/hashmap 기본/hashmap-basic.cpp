#include <iostream>
#include <string>
#include<unordered_map>

using namespace std;

string convert(unordered_map<int, int>::iterator& it, const unordered_map<int, int>& map){
    return (it==map.end()?"None":to_string(it->second));
}

void action_with(unordered_map<int, int>& map, const string action, const int k){
    if(action=="add"){
        int v = 0;
        cin>>v; 
        map[k] = v; 
    }else if(action=="find"){
        auto it = map.find(k);
        cout<<convert(it, map)<<endl;; 
    }else if(action=="remove"){
        map.erase(k); 
    }
}

int main() {

    unordered_map<int, int> map; 

    int n = 0;
    cin>>n;

    for(int query=0; query<n; query++){
        string action = "";
        int k = 0; 

        cin>>action>>k; 
        action_with(map, action, k); 
    }

    return 0;
}

