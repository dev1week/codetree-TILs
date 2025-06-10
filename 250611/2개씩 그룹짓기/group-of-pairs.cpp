#include <iostream>
#include <algorithm>
using namespace std;

int n; 
int numbers[1000];
int main() {

    cin>>n; 

    for(int i=0; i<2*n; i++){
        cin>>numbers[i];
    }

    sort(numbers, numbers+2*n);

    int partSum = 0;
    int result = 0; 

    for(int i=0; i<n; i++){
        int partSum = numbers[i] + numbers[2*n-i-1];

        if(partSum>result){
            result = partSum;
        }
    }

    cout<<result;



    return 0;
}