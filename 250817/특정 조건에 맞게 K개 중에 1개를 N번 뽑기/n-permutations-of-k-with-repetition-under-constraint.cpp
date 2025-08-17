#include <iostream>
#include <vector> 
using namespace std;





bool condition(vector<int>& seq, int current){
    if(current<=1) return true; 
    return (seq[current]==seq[current-1])&&seq[current-1]==seq[current-2]?false:true; 
}


void print(vector<int>& seq){
    for(auto num: seq){
        cout<<num<<" ";
    }
    cout<<endl; 
}

void generate_seq(int k, int n, int current, vector<int>&seq){
    if(current==n){
        print(seq); 
        return;
    }
    
    for(int next=1; next<=k; next++){
        seq[current]= next; 
        if(condition(seq, current)){
            generate_seq(k, n, current+1, seq); 
        }
    }
    return;  
}


int main() {
    int K, N;
    cin >> K >> N;
    vector<int> seq(N, 0); 
    generate_seq(K,N,0, seq); 

    return 0;
}
