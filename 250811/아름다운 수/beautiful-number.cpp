#include <iostream>
#include <vector> 
using namespace std;


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

int count_beautiful(vector<int>&seq, int current, int n){
    if(current==n){
        return is_beautiful(seq)?1:0; 
    }
    int result = 0; 
    for(int next=1; next<=4; next++){
        seq[current] = next; 
        result += count_beautiful(seq, current+1, n); 
    }

    return result; 
}

int main() {
    int n; 
    cin >> n;
    vector<int> sequence(n); 
    //1~4 중 n자리 순열을 구한다. 
    int result = count_beautiful(sequence, 0, n); 
    cout<<result;
    return 0;
}
