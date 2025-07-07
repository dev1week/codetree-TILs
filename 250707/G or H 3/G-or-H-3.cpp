#include <iostream>
#include<algorithm> 
using namespace std;

int N, K;
int x[100];
char c[100];

const int G = 1;
const int H = 2; 
const int MAX_WIDTH = 10001; 


int get_score(char c){
    if(c=='G')return G; 
    if(c=='H')return H; 
    return 0; 
}

int main() {
    cin >> N >> K;

    char people[MAX_WIDTH] = {}; 


    for (int i = 0; i < N; i++) {
        cin >> x[i] >> c[i];

        people[x[i]] = c[i]; 
    }


    int result = 0; 
    for(int i=0; i<MAX_WIDTH-K; i++){
        int part_sum = 0; 
        for(int offset=0; offset<=K; offset++){
            part_sum += get_score(people[offset+i]);
        }

        result = max(part_sum, result); 
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}