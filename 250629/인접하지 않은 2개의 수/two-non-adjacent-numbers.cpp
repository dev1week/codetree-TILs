#include <iostream>
#include <algorithm> 
using namespace std;

int n;
int numbers[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }

    int result = 0; 
    for(int start=0; start<n; start++){
        for(int end=start+2; end<n; end++){
            result = max(result, numbers[start]+numbers[end]);
        }
    }

    cout<<result; 

    return 0;
}