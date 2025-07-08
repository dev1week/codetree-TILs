#include <iostream>

using namespace std;

int N;
int x1[100], x2[100];

bool cond(int s1, int s2, int e1, int e2){
    return s1<s2&&e2<e1; 
}


bool is_over(int start1, int end1, int start2, int end2){
    //
    return cond(start1, start2, end1, end2)||cond(start2, start1, end2, end1); 
}


bool is_any_over_line(int i){
    for(int j=0; j<N; j++){
        if(i==j)continue; 
        if(is_over(x1[i], x2[i], x1[j], x2[j])){
            return false; 
        }
    }

    return true; 
}




int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> x1[i] >> x2[i];
    }

    int cnt = 0; 
    for(int i=0; i<N; i++){
        if(is_any_over_line(i)){
            cnt++; 
        }
    }
    cout<<cnt; 

    return 0;
}