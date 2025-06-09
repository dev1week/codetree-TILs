#include <iostream>
#include <algorithm>
#include <functional> 

using namespace std;

int n;
int nums[100];

void print(int nums[], int n){
    for(int i=0; i<n; i++){
        cout<<nums[i]<<" ";
    }
    cout<<endl;
}

int main() {
    
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    sort(nums, nums+n);
    print(nums, n);
    sort(nums, nums+n, greater<int>());
    print(nums,n);

    return 0;
}
