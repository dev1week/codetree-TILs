#include <iostream>
using namespace std;

int main() {
    int n,m,k; 
    cin>>n>>m>>k; 
    int cnt[n+1] ={}; 

    for(int i=0; i<m; i++){
        int student = 0;
        cin>>student; 
        cnt[student]++; 
        if(cnt[student]>=k){
            cout<<student; 
            break;
        }
    }

    return 0;
}