#include <iostream>

using namespace std;

int m1, d1, m2, d2;

int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31}; 

int convertDay(int month, int day){
    int total = 0; 
    for(int i=1; i<month; i++){
        total += days[i];
    }

    return total+day; 

}

int main() {
    cin >> m1 >> d1 >> m2 >> d2;


    cout<<convertDay(m2,d2)-convertDay(m1,d1)+1; 
    // Please write your code here.

    return 0;
}