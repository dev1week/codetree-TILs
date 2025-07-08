#include <iostream>
#include <algorithm> 
using namespace std;

int N;
int pos[100];
char alpha[100];
const int MAX_WIDTH = 101; 

bool is_only(int cnt1, int cnt2){
    return (cnt1==0&&cnt2>0)||(cnt2==0&&cnt1>0); 
}

bool is_same_cnt(int cnt1, int cnt2){
    if(cnt1==0)return false; 
    if(cnt2==0)return false; 
    return cnt1==cnt2; 
}



bool is_valid(int start, int end, char map[]){
    int g_cnt = 0;
    int h_cnt = 0; 

    for(int i=start; i<=end; i++){
        if(map[i]=='G')g_cnt++;
        else if(map[i]=='H')h_cnt++; 
    }

    return is_only(g_cnt, h_cnt)||is_only(h_cnt, g_cnt)||is_same_cnt(g_cnt, h_cnt); 
}





bool in_range(int end){
    return end<MAX_WIDTH; 
}

int main() {
    cin >> N;
    char map[MAX_WIDTH] = {}; 
    for (int i = 0; i < N; i++) {
        cin >> pos[i] >> alpha[i];

        map[pos[i]] = alpha[i]; 
    }


    int result = 0; 
    for(int start=0; start<MAX_WIDTH; start++){
        if(!(map[start]=='G'||map[start]=='H'))continue; 
        for(int size=0; size<MAX_WIDTH; size++){
            int end = start + size;
            if(!(map[end]=='G'||map[end]=='H'))continue; 
            if(result>size)continue;  
            if(in_range(end)){

                if(is_valid(start, end, map)){
                    result = max(result, size); 
                }
            }
        }
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}