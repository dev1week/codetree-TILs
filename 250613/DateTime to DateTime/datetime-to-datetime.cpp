#include <iostream>

using namespace std;

int a, b, c;

int get_time(int day, int hour, int min){
    return day*24*60+hour*60+min; 
}

int main() {
    cin >> a >> b >> c;

    // Please write your code here.
    cout<<get_time(a,b,c)-get_time(11,11,11);

    return 0;
}