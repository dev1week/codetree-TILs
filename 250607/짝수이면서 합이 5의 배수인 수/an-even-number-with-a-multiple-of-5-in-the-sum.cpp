#include <iostream>

using namespace std;

int n;

bool isFives(int n){
    int sum =0; 
    while(n>0){
        sum += (n%10);
        n /= 10; 
    }

    return sum%5==0;

}

bool isValid(int n){
    return n%2==0&&isFives(n);
}

int main() {
    cin >> n;

    if(isValid(n)){
        cout<<"Yes";
    }else{
        cout<<"No";
    }
    return 0;
}