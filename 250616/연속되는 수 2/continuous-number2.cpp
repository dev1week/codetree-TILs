#include <iostream>

using namespace std;

int N;
int arr[1000];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    int prev = -1;
    int prevCnt = 0; 

    int result = 0; 
    for(int i=0; i<N; i++){
        if(arr[i]==prev){
            prevCnt++; 
            if(result<prevCnt){
                result = prevCnt; 
            }
        }else{
            prev = arr[i]; 
            if(result<prevCnt){
                result = prevCnt; 
            }
            prevCnt = 1; 
        }
    }

    cout<<result; 
    //순회한다. 
        //직전수와 같은 경우 
            //직전수가 나온횟수 ++; 
        //직전수와 다른 경우 
            //현재까지 직전수가 나온 횟수로 최대값을 갱신한다. 
            //직전수를 업데이트한다. 

    // Please write your code here.

    return 0;
}