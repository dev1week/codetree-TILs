#include <iostream>

using namespace std;

int a, b;

bool isThreeOrSixOrNine(int n){
    while(n>0){
        int oneDigit = n%10; 

        if(oneDigit==3||oneDigit==6||oneDigit==9){
            return true; 
        }
        n /=10;
    }
    return false; 
}

bool isMultipleOfThree(int n){
    return n%3==0; 
}

bool isMagicNumber(int n){

    return isMultipleOfThree(n)||isThreeOrSixOrNine(n);
}



int main() {
    cin >> a >> b;

    int cnt = 0; 
    for(int i=a; i<=b; i++){
        if(isMagicNumber(i)){
            cnt++; 
        }
    }


    cout<<cnt;

    // Please write your code here.

    return 0;
}