#include <iostream>
#include <vector> 
using namespace std;

int n;
vector<int> digit; 

void print(){
    for(int i=digit.size()-1; i>=0; i--){
        cout<<digit[i]; 
    }
    cout<<endl; 
}

int main() {
    cin >> n;

    //print(); 
    while(true){
        if(n<2){
            digit.push_back(n);
            break;
        }else{   
            digit.push_back(n%2);
            n /= 2; 
        }
    }
    print(); 



    return 0;
}