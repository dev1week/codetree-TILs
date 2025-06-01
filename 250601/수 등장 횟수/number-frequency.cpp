#include <iostream>
#include <unordered_map>
using namespace std;

const int MAX_N = 100000;

int n, m;
int arr[MAX_N];
int nums[MAX_N];

int main() {
    unordered_map<int, int> cnt; 
    cin >> n >> m;
    //n개의 수열 정보 
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        //해시에 없는 경우 
        if(cnt.find(arr[i])==cnt.end()){
            cnt.insert({arr[i],1});
        }else{
            cnt[arr[i]]++; 
        }
    }

    //nums[i]가 arr[i]에서 몇개 있는지 판단하기 
    for (int i = 0; i < m; i++) {
        cin >> nums[i];
        cout << cnt[nums[i]]<<" ";
    }

    // Please write your code here.

    return 0;
}
