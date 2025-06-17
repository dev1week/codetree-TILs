#include <iostream>
using namespace std;

int main() {
    int n,m,k; 
    cin>>n>>m>>k; 
    int cnt[n+1] ={}; 
    bool flag = true; 

    for(int i=0; i<m; i++){
        int student = 0;
        cin>>student; 
        cnt[student]++; 
        if(cnt[student]>=k){
            flag = false; 
            cout<<student; 
            break;
        }
    }

    if(flag){
        cout<<-1; 
    }

    return 0;
}