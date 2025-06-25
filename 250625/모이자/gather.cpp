#include <iostream>

using namespace std;

int n;
int A[100];

int abs(int n){

    return n>0?n:(-1)*n; 
}

int max(int a, int b){
    return a<b?a:b; 
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }


    int result = 10000001; 
    for(int select=1; select<=n; select++){
        int tmpSum = 0; 
        for(int position=0; position<n; position++){
            int dist = abs(position+1-select); 
            tmpSum += dist*A[position]; 
        }
        result = max(result, tmpSum); 
    }

    cout<<result; 

    return 0;
}