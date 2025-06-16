#include <iostream>

using namespace std;

int N;
int arr[1000];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }


    //순회한다. 
        //직전값과 비교해본다 
            //같을 경우 
                //길이 ++
            //다를 경우 
                //부호를 바꾼다. 
                //길이를 리셋한다.
            //길이의 최대값을 갱신한다. 


    int result = 0; 
    int partLength = 0;
    int prev =1; 

    //같은 부호를 곱하면 양수가 나온다. 
    for(int i=0; i<N; i++){
        if(prev*arr[i]>0){
            partLength++; 
        }else{
            prev = arr[i]; 
            partLength = 1; 
        }

        if(result<partLength){
            result = partLength; 
        }
    }
    // Please write your code here.

    cout<<result; 
    return 0;
}