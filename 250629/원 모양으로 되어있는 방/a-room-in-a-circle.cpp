#include <iostream>
#include <algorithm> 
using namespace std;

int n;
int a[1003];

int get_dist(int start, int end, int max){
    if(end>start){
        return end-start; 
    }else{
        return max-start+end; 
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <=n; i++) {
        cin >> a[i];
    }

    // Please write your code here.
    int result = 100301; 
    for(int start=1; start<=n; start++){
        int part_sum = 0; 
        for(int end=1; end<=n; end++){
            if(start==end)continue; 
            part_sum+= a[end]*get_dist(start, end, n);
        }

        result = min(part_sum, result);
    }

    cout<<result; 

    return 0;
}