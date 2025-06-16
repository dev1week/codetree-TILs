#include <iostream>
#include <vector> 
using namespace std;

int N, B;
vector<int> result; 
int main() {
    cin >> N >> B;

    while(true){
        if(N<B){
            result.push_back(N);
            break; 
        }else{
            result.push_back(N%B);
            N /= B;
        }
    }

    for(int i=result.size()-1; i>=0; i--){
        cout<<result[i]; 
    }
    // Please write your code here.

    return 0;
}