#include <iostream>
#include <string>

using namespace std;

string text;
string pattern;

int process(){

    for(int start=0; start<text.length()-pattern.length()+1; start++){
        int cnt = 0; 
        
        for(int j=0; j<pattern.length(); j++){
            if(text[start+j]==pattern[j]){
                cnt++; 
            }else{
                break; 
            }
        }
        if(cnt==pattern.length()){
            return start; 
        }
    }
    return -1; 
}


int main() {
    cin >> text;
    cin >> pattern;
    
    cout<<process();
    // Please write your code here.

    return 0;
}