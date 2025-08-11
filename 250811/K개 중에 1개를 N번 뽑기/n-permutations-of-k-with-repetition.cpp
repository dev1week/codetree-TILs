#include <iostream>
#include <vector> 
using namespace std;

void print(vector<int>&result){
    for(int num:result){
        cout<<num<<" ";
    }
    cout<<endl; 
}

void choose(vector<int>&result, int k, int n, int current){
    if(current==n){
        print(result); 
        return; 
    }
    for(int i=1; i<=k; i++){
        result[current] = i; 
        choose(result, k,n, current+1); 
    }
}


int main() {
    int K, N;
    cin >> K >> N;
    vector<int> result(N,0); 
    //k까지의 수 중 n번 뽑는다. 
    choose(result, K,N, 0); 
}
