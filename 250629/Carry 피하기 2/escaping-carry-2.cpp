#include <iostream>
#include <algorithm>
#include <string> 
using namespace std;

int n;
int arr[20];

bool is_valid(int n1, int n2, int n3){
    
    int offset = 10;

    while(offset<=10000){
        int tmp = n1%offset+n2%offset+n3%offset; 
        offset *= 10; 
        //cout<<tmp<<endl;
        if(tmp>9) return false; 
    }

    return true; 
}


int sum(int n1, int n2, int n3){
    return is_valid(n1, n2, n3)?n1+n2+n3:-1; 
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int result = -1;

    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            for(int k=j+1; k<n; k++){
                result = max(result, sum(arr[i], arr[j], arr[k]));
            }
        }
    }
    cout<<result;

    // Please write your code here.

    return 0;
}