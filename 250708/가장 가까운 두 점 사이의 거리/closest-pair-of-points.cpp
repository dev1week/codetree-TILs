#include <iostream>
#include <climits> 
using namespace std;

int n;
int x[100], y[100];

int doub(int num){
    return num*num; 
}
int get_dist(int x1, int y1, int x2, int y2){
    return doub(x1-x2) + doub(y1-y2); 
}


int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }


    int result = 90000001;  
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            result = min(result, get_dist(x[i], y[i], x[j], y[j])); 
        }
    }

    cout<<result; 

    // Please write your code here.

    return 0;
}