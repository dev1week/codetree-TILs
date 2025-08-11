#include <iostream>
#include <vector> 
using namespace std;

void print(vector<int>&result){
    for(int num:result){
        cout<<num<<" ";
    }
    cout<<endl; 
}

void choose(vector<int>&result, int k, int n){
    if(result.size()==n){
        print(result); 
        return; 
    }

    for(int i=1; i<=k; i++){
        result.push_back(i);
        choose(result, k,n); 
        result.pop_back(); 
    }


}


int main() {
    int K, N;

    cin >> K >> N;

    vector<int> result; 
    //k까지의 수 중 n번 뽑는다. 
    choose(result, K,N); 


}
