#include <iostream>
#include <algorithm>  

using namespace std;

int n;
int A[100];
int B[100];

bool isSame(int a[], int b[], int n){
    for(int i=0; i<n; i++){
        if(a[i]!=b[i]){
            return false; 
        }
    }
    return true; 
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> B[i];
    }

    sort(A, A+n);
    sort(B, B+n); 

    if(isSame(A,B, n)){
        cout<<"Yes";
    }else{
        cout<<"No";
    }
    // Please write your code here.

    return 0;
}