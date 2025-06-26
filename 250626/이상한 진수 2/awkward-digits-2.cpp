#include <iostream>

using namespace std;

int convert_digit(string &data){
    int part = 1; 
    int result = 0; 

    for(int i=data.length()-1; i>=0; i--){
        result += (data[i]-'0')*part; 
        part*=2; 
    }

    return result; 

}

char convert(int n){
    return n=='0'?'1':'0'; 
}
int main() {
    string a = "";
    cin >> a;

    int result = 0; 

    for(int i=0;i<a.length(); i++){
        if(a[i]=='1')continue; 
        a[i] = convert(a[i]);
        int number = convert_digit(a);
        a[i] = convert(a[i]);

        if(result<number){
            result = number; 
        }
    }

    cout<<result; 
    // Please write your code here.

    return 0;
}