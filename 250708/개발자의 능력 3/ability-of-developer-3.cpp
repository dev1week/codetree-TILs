#include <iostream>
#include <algorithm> 
using namespace std;

int abilities[6];

int abs(int num){
    return num>0?num:(-1)*num; 
}

int main() {
    int tot = 0; 
    for (int i = 0; i < 6; i++) {
        cin >> abilities[i];
        tot+=abilities[i]; 
    }
    int result = 60000000; 
    for(int i=0; i<6; i++){
        for(int j=i+1; j<6; j++){
            for(int k=j+1; k<6; k++){

                int team1 = abilities[i] + abilities[j]+abilities[k]; 
                int team2 = tot - team1;

                result = min(result, abs(team1-team2));
            }
        }
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}