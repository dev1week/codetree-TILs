#include <iostream>

using namespace std;

int a, b;


bool isPrimeNumber(int n){
    if(n==2){
        return true; 
    }

    for(int i=2; i<n; i++){
        if(n%i==0){
            return false; 
        }
    }

    return true; 

}
int main() {
    cin >> a >> b;

    int result = 0; 

    for(int i=a; i<=b; i++){
        if(isPrimeNumber(i)){
            result += i; 
        }
    }

    cout<<result; 

    return 0;
}