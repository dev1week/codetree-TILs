#include <iostream>

using namespace std;

int N;
int a, b, c;

int abs(int num){
    return num>0?num:(-1)*num; 
}

bool is_open(int i, int j, int k, int a, int b, int c){
    if(abs(i-a)<=2) return true; 
    if(abs(j-b)<=2) return true; 
    if(abs(k-c)<=2) return true; 
    return false; 
}

int main() {
    cin >> N;
    cin >> a >> b >> c;
    int cnt = 0; 
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            for(int k=1; k<=N; k++){
                if(is_open(i, j, k, a,b,c)){
                    cnt++; 
                }
            }
        }
    }

    cout<<cnt; 
    return 0;
}