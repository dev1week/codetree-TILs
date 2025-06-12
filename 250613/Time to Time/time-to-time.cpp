#include <iostream>

using namespace std;

int a, b, c, d;

int convertTime(int h, int m){
    return h*60+m; 
}

int main() {
    cin >> a >> b >> c >> d;

    cout<<convertTime(c,d)-convertTime(a,b);

    return 0;
}