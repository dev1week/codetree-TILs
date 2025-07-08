#include <iostream>
#include <algorithm> 
using namespace std;

int N, B;
int P[1000];



int main() {
    cin >> N >> B;
    for (int i = 0; i < N; i++) {
        cin >> P[i];

    }

    // Please write your code here.
    int result = 0; 

    for(int selected=0; selected<N; selected++){
        int tmp[N] = {}; 
        for(int i=0; i<N; i++){
            if(selected==i){
                tmp[i] = P[i]/2; 
            }else{
                tmp[i] = P[i];
            }
        }
        sort(tmp, tmp+N); 

        int idx = 0;
        int part_cost = 0; 
        while(part_cost+tmp[idx]<=B){
            part_cost+=tmp[idx]; 
            idx++; 
        }
        result = max(result, idx); 
    }

    cout<<result; 
    //반값 쿠폰정하기 
        //쿠폰 적용하여 반값으로 만들기 

        //정렬하기 

        //작은값부터 더해가면서 최대인원 찾기 

        //최대 인원 갱신하기 

    return 0;
}