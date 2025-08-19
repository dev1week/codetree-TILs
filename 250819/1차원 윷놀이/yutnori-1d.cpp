#include <iostream>
#include <vector>
#include <algorithm> 
using namespace std;




//마지막 칸의 번호 M 
    //도달할 경우 1점 
    //선택할 수는 있지만 아무런 변화 없음 
//말의 갯수 K 





//주어지는 숫자 n 
//1~k를 n개 선택하기 
    //선택한 조합으로 움직였을 때 점수 계산하기 
    
        //점수 최댓값 갱신하기 
void print(vector<int> seq){
    if(seq[0]!=0){
        for(auto num : seq){
            cout<<num<<" ";
        }
        cout<<endl; 
    }
    
    
}

int get_score(vector<int>& seq, vector<int>& moves, int n, int m, int k){
    vector<int> positions(k,1); 
    for(int i=0; i<n; i++){
        positions[seq[i]]+=moves[i]; 
    }
    int score = 0; 
    for(auto position: positions){
        if(position>=m){
            score++; 
        }
    }
    //cout<<"움직이는 말 순서"<<endl;
    // print(seq); 
    // if(seq[0]!=0){
    //     cout<<"움직임 범위"<<endl;
    //     print(moves);
    //     cout<<"최종 위치"<<endl; 
    //     print(positions); 
    //     cout<<score<<endl; 
    // }
    
    return score; 
}

int generate_seq(vector<int> seq, int n, int m, int k, int current, vector<int> moves){
    if(current==n){
        int score = get_score(seq, moves, n, m, k);
        return score; 
    }

    int max_score = 0; 
    for(int next=0; next<k; next++){
        seq[current] = next; 
        max_score = max(max_score, generate_seq(seq, n, m,k,current+1, moves)); 
    }

    return max_score;
}
int get_max(vector<int>& seq, int n, int m, int k, vector<int> moves){
    int max = generate_seq(seq, n, m, k, 0, moves); 
    return max; 
}




int main() {
    int n,m,k; 
    cin >> n >> m >> k;
    vector<int> moves (n); 
    for (int i = 0; i < n; i++) {
        cin >> moves[i];
    }
    vector<int> seq(n);
    cout<<get_max(seq, n,m,k, moves);     
    return 0;
}
