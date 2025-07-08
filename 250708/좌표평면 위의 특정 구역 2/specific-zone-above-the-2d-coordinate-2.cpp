#include <iostream>
#include <algorithm> 
using namespace std;

int N;
int x[100], y[100];

int get_size(int x1, int y1, int x2, int y2){
    return abs(x1-x2)*abs(y2-y1); 
}

int abs(int num){
    return num>0?num:(-1)*num; 
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> x[i] >> y[i];
    }

    int result = 2119999999; 

    for(int skip=0; skip<N; skip++){
        //좌하단 좌표 
        int x1 = 40001; 
        int y1 = 40001;

        //우상단 좌표 
        int x2 =0;
        int y2 =0; 
        for(int line=0; line<N; line++){
            if(line==skip)continue; 
            x1 = min(x1, x[line]);
            y1 = min(y1, y[line]);

            x2 = max(x2, x[line]);
            y2 = max(y2, y[line]);


        }   
        result = min(result, get_size(x1, y1, x2, y2)); 

        //선을 순회한다. 
            //스킵해야하는 선은 스킵한다. 
                //가장 좌측 x좌표를 찾는다. 
                //가장 상단 y 좌표를 찾는다. 
                //가장 우측 x좌표를 찾는다. 
                //가장 하단 y좌표를 찾는다. 
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}