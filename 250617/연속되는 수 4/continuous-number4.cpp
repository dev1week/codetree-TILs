#include <iostream>

using namespace std;

int N;
int arr[1000];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    int partialCnt = 0;
    int result = 0; 
    int prev = 0; 

    for(int i=0; i<N; i++){
        if(arr[i]>prev){
            partialCnt++;
        }else{
            partialCnt = 1; 
        }
        prev = arr[i]; 
        if(result<partialCnt){
            result = partialCnt; 
        }
    }

    cout<<result; 

    //배열을 순회
        //전 숫자보다 큰 경우 
            //카운팅한다 
        //전 숫자보다 작은 경우 
            //전 숫자를 갱신한다 
        
        //카운트의 최대값을 갱신한다. 

    // Please write your code here.

    return 0;
}