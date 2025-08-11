#include <iostream>
#include <vector> 
using namespace std;

int result = 0; 

void print(const vector<int>&seq){
    for(int num : seq){
        cout<<num<<" ";
    }
    cout<<endl; 
}

bool is_beautiful(vector<int>&seq){
    for(int i=0; i<seq.size(); i++){
        int current = seq[i]; 
        int cnt = 0; 
        for(int offset=0; offset<current; offset++){
            if(current==seq[i+offset])cnt++; 
        }
        if(cnt!=current) return false; 
        i += (current-1); 
    }
    return true; 
}

void generate_sequence(vector<int>&seq, int current, int n){
    if(current==n){
        if(is_beautiful(seq)){
            result++; 
        }
        return; 
    }
    for(int next=1; next<=4; next++){
        seq[current] = next; 
        generate_sequence(seq, current+1, n); 
    }
}

int main() {
    int n; 
    cin >> n;
    vector<int> sequence(n); 
    //1~4 중 n자리 순열을 구한다. 
    generate_sequence(sequence, 0, n); 
    cout<<result;
    return 0;
}
