#include <iostream>

using namespace std;

int n, t;
int arr[1000];

int main() {
    cin >> n >> t;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Please write your code here.

    int result = 0; 
    int partialLen =0; 
    for(int i=0; i<n; i++){
        if(arr[i]>t){
            partialLen++; 
        }else{
            partialLen = 0; 
        }

        if(partialLen>result){
            result = partialLen; 
        }
    }

    cout<<result; 
    //배열을 순회한다 
        //T보다 클때 
            //배열의 길이를 증가시킨다 
        //작을 때
            //배열의 시작점이 된다. 
            //배열의 길이를 리셋한다.  
        
        //배열 길이의 최댓값을 갱신한다. 
    return 0;
}