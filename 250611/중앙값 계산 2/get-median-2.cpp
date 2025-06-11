#include <iostream>
#include <algorithm> 
using namespace std;

int numbers[100000]; 
int n; 
int main() {

    cin>>n; 

    for(int i=0; i<n; i++){
        cin>>numbers[i];
        if(i%2==0){
            sort(numbers, numbers+i+1);
            
            cout<<numbers[i/2]<<" "; 
        }
    }





    return 0;
}