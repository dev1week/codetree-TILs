#include <iostream>
#include <string> 
#include <vector> 
using namespace std;


int convert(string &n){
    int result = 0; 
    int offset = 1; 

    for(int i=n.size()-1; i>=0; i--){
        if(n[i]=='1'){
            result += offset;  
        }
        offset *=2; 
    }
    return result; 
}

vector<int> get_digit(int number){
    vector<int> result; 
    while(true){
        if(number<2){
            result.push_back(number); 
            break; 
        }else{
            result.push_back(number%2);
            number/=2;
        }
    }
    return result; 
}

void print(vector<int> &result){
    for(int i=result.size()-1; i>=0; i--){
        cout<<result[i];
    }
}

int main() {
    string N;
    cin >> N;

    // Please write your code here.

    //십진수로 바꾸기 
    int number = convert(N)*17; 
    vector<int> result = get_digit(number); 
    //이진수로 바꾸기 
    print(result); 
    


    //출력하기 

    return 0;
}