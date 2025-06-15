#include <iostream>
#include <vector> 
using namespace std;

int K, N;

vector<int> result; 

void print(){
    for(int i=0; i<result.size(); i++){
        cout<<result[i]<<" ";
    }
    cout<<endl; 
}

void choose(int cur){
    if(cur==N){
        print(); 
        return; 
    }

    for(int i=1; i<=K; i++){
        result.push_back(i);
        choose(cur+1); 
        result.pop_back(); 
    }

}

int main() {
    cin >> K >> N;

    choose(0); 
    // Please write your code here.

    return 0;
}
