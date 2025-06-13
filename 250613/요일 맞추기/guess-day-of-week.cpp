#include <iostream>
#include <string> 
using namespace std;

int m1, d1, m2, d2;
int offset = 7777; 
string weekdays[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
int days[] ={0, 31,28, 31, 30,31, 30,31,31,30,31,30,31}; 

int getDayCnt(int m, int d){
    int result = 0; 
    for(int month=1; month<m; month++){
        result += days[month]; 
    }

    return result + d; 
}


int main() {
    cin >> m1 >> d1 >> m2 >> d2;

    // 날짜 차이를 구한다 
    int interval = getDayCnt(m2, d2)-getDayCnt(m1,d1)+7777; 

    //7로 나눈 몫으로 요일을 정한다. 
    cout<<weekdays[interval%7];
    return 0;
}