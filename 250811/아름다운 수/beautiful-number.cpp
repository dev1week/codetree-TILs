#include <iostream>
#include <vector> 
#include <functional> 
using namespace std;


void print(const vector<int>&seq){
    for(int num : seq){
        cout<<num<<" ";
    }
    cout<<endl; 
}


int count_seq_matching_condition(vector<int>&seq, int current, int n,
    const function<bool(vector<int>&)>& is_count){
    if(current==n){
        return is_count(seq)?1:0; 
    }
    int result = 0; 
    for(int next=1; next<=4; next++){
        seq[current] = next; 
        result += count_seq_matching_condition(seq, current+1, n, is_count); 
    }

    return result; 
}

int main() {
    int n; 
    cin >> n;
    vector<int> sequence(n); 
    //1~4 중 n자리 순열을 구한다. 

    auto is_beaultiful = [&](vector<int>&seq)->bool{
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
    };


    int result = count_seq_matching_condition(sequence, 0, n, is_beaultiful); 
    cout<<result;
    return 0;
}
